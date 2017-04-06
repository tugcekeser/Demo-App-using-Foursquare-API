package com.example.tuze.remindtakehome.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tuze.remindtakehome.R;

import java.util.List;

public class CityAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> countryNameList;
    private List<String> cityNameList;
    private List<Integer> cityImageList;
    private Context context;

    public CityAdapter(Context context, List<String> countryNameList, List<String> cityNameList, List<Integer> cityImageList) {
        this.cityImageList = cityImageList;
        this.cityNameList = cityNameList;
        this.countryNameList = countryNameList;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View viewCity = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_city, parent, false);
        RecyclerView.ViewHolder viewHolder = new CityViewHolder(viewCity, context);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        final String cityName = cityNameList.get(position);
        final String countryName = countryNameList.get(position);
        final int cityImage = cityImageList.get(position);

        CityViewHolder vhCity = (CityViewHolder) holder;
        vhCity.setValues(cityName,countryName,cityImage);

    }
    @Override
    public int getItemCount() {
        return cityImageList.size();
    }
}
