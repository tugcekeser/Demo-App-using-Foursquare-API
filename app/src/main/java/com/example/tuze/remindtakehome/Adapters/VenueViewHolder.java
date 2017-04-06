package com.example.tuze.remindtakehome.Adapters;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tuze.remindtakehome.Activities.DisplayPhotosActivity;
import com.example.tuze.remindtakehome.Constants.AppConstants;
import com.example.tuze.remindtakehome.DB.BookMarkedDB;
import com.example.tuze.remindtakehome.Models.Category;
import com.example.tuze.remindtakehome.Models.ItemExplore;
import com.example.tuze.remindtakehome.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VenueViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.ivVenueImage)
    ImageView ivVenueImage;
    @BindView(R.id.tvAddress)
    TextView tvAddress;
    @BindView(R.id.ivBookMark)
    ImageView ivBookMark;
    @BindView(R.id.rvCategories)
    RecyclerView rvCategories;
    Context context;
    private int marked = 0;
    private static List<String> tagList;

    public VenueViewHolder(View v, Context context) {
        super(v);
        ButterKnife.bind(this, v);
        this.context = context;
    }

    public void setValues(final ItemExplore item) {
        if (item.getVenue().getFeaturedPhotos() != null) {
            Picasso.with(context)
                    .load(item.getVenue().getFeaturedPhotos().getItems().get(0).getPrefix()
                            + AppConstants.IMAGE_SIZE + item.getVenue().getFeaturedPhotos().getItems().get(0).getSuffix())
                    .into(ivVenueImage);
        }
        if (item.getVenue().getName() != null)
            tvName.setText(item.getVenue().getName());
        if (item.getVenue().getLocation().getAddress() != null)
            tvAddress.setText(item.getVenue().getLocation().getAddress());
        setTags(item.getVenue().getCategories());
        saveBookmarkedVenue(item.getVenue().getId());

        ivVenueImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DisplayPhotosActivity.class);
                intent.putExtra(AppConstants.VENUE_ID, item.getVenue().getId());
                intent.putExtra(AppConstants.BOOKMARKED, marked);
                intent.putExtra(AppConstants.VENUE_NAME, item.getVenue().getName());
                context.startActivity(intent);
            }
        });
    }

    private void setTags(List<Category> categoryList) {
        if (categoryList == null)
            return;

        tagList = new ArrayList<String>();
        for (int i = 0; i < categoryList.size(); i++) {
            String category = new String();
            category = "#" + categoryList.get(i).getName();
            tagList.add(category);
        }
        CategoryTagAdapter adapter = new CategoryTagAdapter(context, tagList);
        rvCategories.setAdapter(adapter);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        rvCategories.setLayoutManager(layoutManager);
    }

    //Save and get venue status(marked/unmarked) in local db
    private void saveBookmarkedVenue(String id) {
        BookMarkedDB db = new BookMarkedDB(context);
        db.open();

        Cursor c = db.getVenue(id);

        //If previously the venue saved, get value
        if (c.moveToFirst() == true) {

            //If the venue unmarked
            if (c.getInt(2) == 0) {
                ivBookMark.setImageResource(R.drawable.bookmark);
                marked = 0;
            } else if (c.getInt(2) == 1) {
                //If the venue marked
                ivBookMark.setImageResource(R.drawable.bookmarked);
                marked = 1;
            }

        } else {
            //If previously the venue is not saved, save venue and mark status as unmarked (0)
            db.insertVenue(id);
        }
        db.close();
    }
}
