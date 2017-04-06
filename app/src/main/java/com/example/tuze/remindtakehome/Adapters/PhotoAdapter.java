package com.example.tuze.remindtakehome.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tuze.remindtakehome.Models.Item;
import com.example.tuze.remindtakehome.R;

import java.util.List;


public class PhotoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Item> photoList;
    private Context context;

    public PhotoAdapter(Context context, List<Item> photoList) {
        this.photoList = photoList;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View viewPhoto = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photo, parent, false);
        RecyclerView.ViewHolder viewHolder = new PhotoViewHolder(viewPhoto, context);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        final Item photo = photoList.get(position);
        PhotoViewHolder vhPhoto = (PhotoViewHolder) holder;
        vhPhoto.setValues(photo);
    }

    @Override
    public int getItemCount() {
        return photoList.size();
    }


    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }
}
