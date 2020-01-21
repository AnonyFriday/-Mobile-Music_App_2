package com.example.SingerPackage.RecyclerView;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.LoginPackage.R;
import com.example.SingerPackage.Entity.Singer;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Random;

public class SingerRecyclerViewAdapter extends RecyclerView.Adapter<SingerViewHolder> {

    private Context mContext;
    private ArrayList<Singer> mSingerArrayList;
    private OnSingerListener mOnSingerListener;
    public String TAG = "ListAdapter";

    public SingerRecyclerViewAdapter(Context context, ArrayList<Singer> singerArrayList, OnSingerListener onSingerListener) {
        mContext = context;
        mSingerArrayList = singerArrayList;
        this.mOnSingerListener = onSingerListener;
    }

    @NonNull
    @Override
    public SingerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_singer_view, null);

        SingerViewHolder singerViewHolder = new SingerViewHolder(view, mOnSingerListener);

        return singerViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull SingerViewHolder singerViewHolder, int position) {

        singerViewHolder.singerTextView.setText(mSingerArrayList.get(position).getName());
        singerViewHolder.singerImageView.setImageResource(mSingerArrayList.get(position).getImageFileName());
    }

    @Override
    public int getItemCount() {
        return mSingerArrayList.size();
    }

    public interface OnSingerListener {
        void onSingerClick(int position);
    }
}
