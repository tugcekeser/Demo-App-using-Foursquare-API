package com.example.tuze.remindtakehome.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.ceylonlabs.imageviewpopup.ImagePopup;
import com.example.tuze.remindtakehome.Constants.AppConstants;
import com.example.tuze.remindtakehome.Models.Item;
import com.example.tuze.remindtakehome.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PhotoViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.ivPhoto)
    ImageView ivPhoto;
    Context context;

    public PhotoViewHolder(View v, Context context) {
        super(v);
        ButterKnife.bind(this, v);
        this.context = context;

    }

    public void setValues(final Item item) {
        if (item.getSuffix() == null || item.getPrefix() == null)
            return;

        Picasso.with(context)
                .load(item.getPrefix()
                        + AppConstants.IMAGE_SIZE + item.getSuffix())
                .into(ivPhoto);

        //Third party library to popup image
        final ImagePopup imagePopup = new ImagePopup(context);
        imagePopup.setBackgroundColor(Color.BLACK);
        imagePopup.setHideCloseIcon(true);
        imagePopup.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imagePopup.setImageOnClickClose(true);


        ivPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imagePopup.initiatePopup(ivPhoto.getDrawable());
            }
        });
    }
}
