package com.example.tuze.remindtakehome.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.example.tuze.remindtakehome.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.lHistoric)
    LinearLayout lHistoric;
    @BindView(R.id.lBeach)
    LinearLayout lBeach;
    @BindView(R.id.lHotel)
    LinearLayout lHotel;
    Context context;

    public CategoryViewHolder(View v, Context context) {
        super(v);
        ButterKnife.bind(this, v);
        this.context = context;
    }

    public LinearLayout getlBeach() {
        return lBeach;
    }

    public LinearLayout getlHistoric() {
        return lHistoric;
    }

    public LinearLayout getlHotel() {
        return lHotel;
    }

}
