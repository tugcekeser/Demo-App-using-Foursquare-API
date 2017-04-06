package com.example.tuze.remindtakehome.Activities;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.tuze.remindtakehome.Adapters.PhotoAdapter;
import com.example.tuze.remindtakehome.Constants.AppConstants;
import com.example.tuze.remindtakehome.DB.BookMarkedDB;
import com.example.tuze.remindtakehome.Models.Item;
import com.example.tuze.remindtakehome.Models.VenuePhotos;
import com.example.tuze.remindtakehome.Network.APIClient;
import com.example.tuze.remindtakehome.R;
import com.example.tuze.remindtakehome.Utils.NetworkUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class DisplayPhotosActivity extends AppCompatActivity {

    private static Integer UNMARKED = 0;
    private static Integer MARKED = 1;
    @BindView(R.id.rvItems)
    RecyclerView rvVenues;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private APIClient client;
    private static List<Item> photoList;
    private VenuePhotos venuePhotos;
    private PhotoAdapter adapter;
    private int bookmarkStatus;
    private String venueId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_photos);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getIntent().getStringExtra(AppConstants.VENUE_NAME) + AppConstants.PHOTOS_TITLE);

        venueId = getIntent().getStringExtra(AppConstants.VENUE_ID);
        bookmarkStatus = getIntent().getIntExtra(AppConstants.BOOKMARKED, 0);

        client = new APIClient();
        photoList = new ArrayList<Item>();

        setRecyclerView();
        fetchVenuePhotos(venueId);
    }

    //Set recyclerview
    private void setRecyclerView() {
        adapter = new PhotoAdapter(this, photoList);
        rvVenues.setAdapter(adapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, getColumnNumber());
        rvVenues.setLayoutManager(gridLayoutManager);
    }

    //Calculate the columns according to screen width
    private int getColumnNumber() {
        if(isTablet(DisplayPhotosActivity.this))
            return 5;
        else
            return 3;

    }

    //Check emulator is tablet or not
    public static boolean isTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout
                & Configuration.SCREENLAYOUT_SIZE_MASK)
                >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }

    //Get venue photos from the server
    private void fetchVenuePhotos(final String venue) {

        //Check the app is connected to network or not
        if (NetworkUtil.isConnected(DisplayPhotosActivity.this)) {

            //Call OKHttp Client
            client.getVenuePhotos(venue, new Callback() {

                @Override
                public void onFailure(Call call, IOException e) {
                    e.printStackTrace();
                }

                @Override
                public void onResponse(final Call call, final Response response) throws IOException {

                    if (NetworkUtil.isOnline()) {
                        final String responseData = response.body().string();

                        // Run view-related code back on the main thread
                        DisplayPhotosActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    JSONObject json = new JSONObject(responseData);
                                    venuePhotos = new VenuePhotos(json);
                                    photoList.addAll(venuePhotos.getResponse().getPhotos().getItems());
                                    adapter.notifyDataSetChanged();

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                }
            });
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_display_photos, menu);

        //Set bookmark icon according to marked or unmarked
        MenuItem menuItemBookMarked = menu.findItem(R.id.bookMark);
        if (bookmarkStatus == UNMARKED)
            menuItemBookMarked.setIcon(R.mipmap.bookmark);
        else
            menuItemBookMarked.setIcon(R.mipmap.bookmarked);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //Update bookmarked icon and venue status in db
        if (id == R.id.bookMark) {
            if (bookmarkStatus == UNMARKED) {
                item.setIcon(R.mipmap.bookmarked);
                bookmarkStatus = MARKED;
                markedUnmarkedVenue(AppConstants.MARKED);

            } else {
                item.setIcon(R.mipmap.bookmark);
                bookmarkStatus = UNMARKED;
                markedUnmarkedVenue(AppConstants.UNMARKED);
            }

        } else if (id == android.R.id.home) {
            this.finish();
        }
        return true;
    }


    //Update venue bookmark status in SQLite Local DB
    private void markedUnmarkedVenue(String message) {
        BookMarkedDB db = new BookMarkedDB(DisplayPhotosActivity.this);
        db.open();

        if (db.updateVenue(venueId, bookmarkStatus) == true)
            Toast.makeText(this, message, Toast.LENGTH_LONG);

        db.close();
    }
}
