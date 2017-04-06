package com.example.tuze.remindtakehome.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tuze.remindtakehome.R;

import java.util.List;

public class CategoryTagAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> tagList;
    private Context context;

    public CategoryTagAdapter(Context context, List<String> tagList) {
        this.tagList = tagList;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View viewCategory = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category_tag, parent, false);
        RecyclerView.ViewHolder viewHolder = new CategoryTagViewHolder(viewCategory, context);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        final String category = tagList.get(position);
        CategoryTagViewHolder vhCategory = (CategoryTagViewHolder) holder;
        vhCategory.setCategory(category);
    }

    @Override
    public int getItemCount() {
        return tagList.size();
    }


    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }}
