package com.example.tuze.remindtakehome.Activities;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.tuze.remindtakehome.Adapters.VenueAdapter;
import com.example.tuze.remindtakehome.Constants.AppConstants;
import com.example.tuze.remindtakehome.Models.CityVenues;
import com.example.tuze.remindtakehome.Models.ItemExplore;
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


public class DisplayVenuesActivity extends AppCompatActivity {
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.rvItems)
    RecyclerView rvVenues;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private APIClient clientVenue;
    private VenueAdapter adapter;
    private CityVenues venues;
    private static List<Object> venueList;
    private String cityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_venues);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        clientVenue = new APIClient();
        venueList = new ArrayList<Object>();

        // //Set toolbar title with city name
        cityName = getIntent().getStringExtra(AppConstants.CITY_NAME);
        getSupportActionBar().setTitle(cityName);

        //Set appbar background with city image
        Integer cityImage = getIntent().getIntExtra(AppConstants.CITY_IMAGE, 0);
        appBar.setBackgroundResource(cityImage);

        fetchVenues(cityName);
        setRecyclerView();
    }

    //Set recyclerView
    private void setRecyclerView() {
        adapter = new VenueAdapter(DisplayVenuesActivity.this, venueList, cityName);
        rvVenues.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvVenues.setLayoutManager(linearLayoutManager);
    }

    //After bookmarked venue, update the venue list
    @Override
    protected void onResume() {
        super.onResume();
        fetchVenues(cityName);
    }

    //Get venues from the server
    private void fetchVenues(String name) {

        //Check the app is connected to network or not
        if (NetworkUtil.isConnected(DisplayVenuesActivity.this)) {

            //Call OKHttp Client
            clientVenue.getVenues(name, null, new Callback() {

                @Override
                public void onFailure(Call call, IOException e) {
                    e.printStackTrace();
                }

                @Override
                public void onResponse(final Call call, final Response response) throws IOException {

                    if (NetworkUtil.isOnline()) {
                        final String responseData = response.body().string();

                        // Run view-related code back on the main thread
                        DisplayVenuesActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    JSONObject json = new JSONObject(responseData);
                                    venues = new CityVenues(json);

                                    //Set venue list items
                                    int i = 0;
                                    for (ItemExplore item : venues.getResponse().getGroups().get(0).getItems()) {
                                        //After each 10th item, add category view
                                        if (i % 10 == 0) {
                                            venueList.add(AppConstants.CATEGORY);
                                        }
                                        venueList.add(item);
                                        i++;
                                    }

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
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            this.finish();
        }
        return true;
    }
}
