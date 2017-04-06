package com.example.tuze.remindtakehome.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.tuze.remindtakehome.Adapters.CityAdapter;
import com.example.tuze.remindtakehome.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DisplayCitiesActivity extends AppCompatActivity {

    private List<String> cityNameList;
    private List<String> countryNameList;
    private List<Integer> cityImageList;
    private CityAdapter adapter;
    @BindView(R.id.rvItems)
    RecyclerView rvCities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_cities);
        ButterKnife.bind(this);

        getCityNames();
        getCityImages();
        getCountryNames();

        adapter = new CityAdapter(this, countryNameList, cityNameList, cityImageList);
        rvCities.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvCities.setLayoutManager(linearLayoutManager);

    }

    private void getCityNames() {
        cityNameList = new ArrayList<String>();
        cityNameList.add("Istanbul");
        cityNameList.add("San Francisco");
        cityNameList.add("Nevsehir");
        cityNameList.add("San Diego");
        cityNameList.add("New York");
    }

    private void getCountryNames() {
        countryNameList = new ArrayList<String>();
        countryNameList.add("TURKEY");
        countryNameList.add("USA");
        countryNameList.add("TURKEY");
        countryNameList.add("USA");
        countryNameList.add("USA");
    }

    private void getCityImages() {
        cityImageList = new ArrayList<Integer>();
        cityImageList.add(R.drawable.istanbul);
        cityImageList.add(R.drawable.sanfrancisco);
        cityImageList.add(R.drawable.nevsehir);
        cityImageList.add(R.drawable.sandiago);
        cityImageList.add(R.drawable.newyork);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_display_cities, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }
}
