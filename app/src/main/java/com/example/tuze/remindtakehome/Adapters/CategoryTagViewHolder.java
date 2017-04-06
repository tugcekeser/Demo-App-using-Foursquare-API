package com.example.tuze.remindtakehome.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.tuze.remindtakehome.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryTagViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tvCategory)
    TextView tvCategory;
    private Context context;

    public CategoryTagViewHolder(View v, Context context) {
        super(v);
        ButterKnife.bind(this, v);
        this.context = context;
    }

    public void setCategory(String category) {
        tvCategory.setText(category);
    }
}
