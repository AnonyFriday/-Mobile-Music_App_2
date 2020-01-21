package com.example.SingerPackage.RecyclerView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.LoginPackage.R;
import com.example.SongPackage.RecyclerView.SongRecyclerViewAdapter;

public class SingerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public final ImageView singerImageView;
    public final TextView singerTextView;


    SingerRecyclerViewAdapter.OnSingerListener mOnSongListener;

    public SingerViewHolder(@NonNull View itemView, SingerRecyclerViewAdapter.OnSingerListener onSongListener) {
        super(itemView);

        this.mOnSongListener = onSongListener;
        singerImageView = itemView.findViewById(R.id.singer_imageView_singer);
        singerTextView = itemView.findViewById(R.id.singer_textView_singer);

        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        mOnSongListener.onSingerClick(getAdapterPosition());
    }
}
