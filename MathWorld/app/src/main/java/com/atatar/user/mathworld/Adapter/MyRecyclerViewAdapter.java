package com.atatar.user.mathworld.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.Image;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.atatar.user.mathworld.R;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private List<Bitmap> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private View view;
    private String type;
    // data is passed into the constructor
    public MyRecyclerViewAdapter(Context context, List<Bitmap> data, String type) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.type = type;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(type.equals("category"))
         view = mInflater.inflate(R.layout.reciclerview_row, parent, false);
        else
            view = mInflater.inflate(R.layout.reciclerview_row_classes, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Bitmap image = mData.get(position);

        holder.image .setImageBitmap(image);

    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView image;

        ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.tv_image);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    public Bitmap getItem(int id) {
        return mData.get(id);
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}



