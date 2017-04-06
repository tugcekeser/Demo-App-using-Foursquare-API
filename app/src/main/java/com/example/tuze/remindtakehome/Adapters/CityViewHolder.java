package com.example.tuze.remindtakehome.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tuze.remindtakehome.Activities.DisplayVenuesActivity;
import com.example.tuze.remindtakehome.Constants.AppConstants;
import com.example.tuze.remindtakehome.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CityViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tvCityName)
    TextView tvCityName;
    @BindView(R.id.ivCityImage)
    ImageView ivCityImage;
    @BindView(R.id.tvCountryName)
    TextView tvCountryName;
    Context context;

    public CityViewHolder(View v, Context context) {
        super(v);
        ButterKnife.bind(this, v);
        this.context = context;
    }

    public void setValues(final String cityName, final String countryName, final int cityImage) {

        ivCityImage.setImageResource(cityImage);
        ivCityImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DisplayVenuesActivity.class);
                intent.putExtra(AppConstants.CITY_NAME, cityName);
                intent.putExtra(AppConstants.CITY_IMAGE, cityImage);
                context.startActivity(intent);
            }
        });

        tvCityName.setText(cityName);
        tvCountryName.setText(countryName);
    }
}
