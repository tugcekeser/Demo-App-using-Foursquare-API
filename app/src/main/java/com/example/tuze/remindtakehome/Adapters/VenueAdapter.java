package com.example.tuze.remindtakehome.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tuze.remindtakehome.Activities.DisplayVenuesActivity;
import com.example.tuze.remindtakehome.Constants.AppConstants;
import com.example.tuze.remindtakehome.Models.CityVenues;
import com.example.tuze.remindtakehome.Models.ItemExplore;
import com.example.tuze.remindtakehome.Network.APIClient;
import com.example.tuze.remindtakehome.R;
import com.example.tuze.remindtakehome.Utils.NetworkUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class VenueAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Object> venueList;
    private Context context;
    private final int VENUE = 0, CATEGORY = 1;
    private APIClient clientVenue;
    private String cityName;

    public VenueAdapter(Context context, List<Object> venueList, String cityName) {
        this.venueList = venueList;
        this.context = context;
        clientVenue = new APIClient();
        this.cityName = cityName;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;

        //If the row is venue
        if (viewType == VENUE) {
            View viewCategory = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_venue, parent, false);
            viewHolder = new VenueViewHolder(viewCategory, context);

        } else {
            //If the row is for categories
            View viewCategory = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
            viewHolder = new CategoryViewHolder(viewCategory, context);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //If the row is venue
        if (getItemViewType(position) == VENUE) {
            final ItemExplore venue = (ItemExplore) venueList.get(position);
            VenueViewHolder vhVenue = (VenueViewHolder) holder;
            vhVenue.setValues(venue);
        } else {
            //If the row is for categories
            CategoryViewHolder vhCategory = (CategoryViewHolder) holder;
            setCategoryListeners(vhCategory);
        }
    }


    private void setCategoryListeners(CategoryViewHolder vhCategory) {

        //Update venue list according to category
        vhCategory.getlHotel().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                venueList.clear();
                fetchVenues(cityName, AppConstants.HOTEL);
            }
        });

        vhCategory.getlBeach().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                venueList.clear();
                venueList.clear();
                fetchVenues(cityName, AppConstants.BEACH);
            }
        });

        vhCategory.getlHistoric().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                venueList.clear();
                venueList.clear();
                fetchVenues(cityName, AppConstants.HISTORIC);
            }
        });
    }

    @Override
    public int getItemCount() {
        return venueList.size();
    }


    @Override
    public int getItemViewType(int position) {
        if (venueList.get(position) instanceof ItemExplore) {
            return VENUE;
        } else if (venueList.get(position) instanceof String) {
            return CATEGORY;
        }
        return -1;
    }

    private void fetchVenues(String name, String category) {

        //Check the app is connected to network or not
        if (NetworkUtil.isConnected(context)) {

            //Call OKHttp Client
            clientVenue.getVenues(name, category, new Callback() {

                @Override
                public void onFailure(Call call, IOException e) {
                    e.printStackTrace();
                }

                @Override
                public void onResponse(final Call call, final Response response) throws IOException {

                    if (NetworkUtil.isOnline()) {
                        final String responseData = response.body().string();

                        // Run view-related code back on the main thread
                        ((DisplayVenuesActivity) context).runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    JSONObject json = new JSONObject(responseData);
                                    CityVenues venues = new CityVenues(json);
                                    int i = 0;
                                    for (ItemExplore item : venues.getResponse().getGroups().get(0).getItems()) {
                                        if (i % 10 == 0) {
                                            venueList.add(AppConstants.CATEGORY);
                                        }
                                        venueList.add(item);
                                        i++;
                                    }

                                    notifyDataSetChanged();

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

}


