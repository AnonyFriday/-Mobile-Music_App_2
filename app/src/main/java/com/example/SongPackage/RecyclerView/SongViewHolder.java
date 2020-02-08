package com.example.SongPackage.RecyclerView;

import android.content.DialogInterface;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.LoginPackage.R;
import com.example.SongPackage.Entity.Song;
import com.example.SongPackage.RecyclerView.SongRecyclerViewAdapter;


//https://www.youtube.com/watch?v=69C1ljfDvl0 // 4:45s
//TODO add the View.OnClickListener if u want to click the element
public class SongViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public final ImageView songImageView;
    public final TextView songNameTextView;

    SongRecyclerViewAdapter.OnSongListener mOnSongListener;

    //TODO add the OnSongListener
    public SongViewHolder(@NonNull View itemView, SongRecyclerViewAdapter.OnSongListener onSongListener) {
        super(itemView);

        songImageView = itemView.findViewById(R.id.singer_imageView_song);
        songNameTextView = itemView.findViewById(R.id.songName_textView_song);
        this.mOnSongListener = onSongListener;

        //TODO add the setOnClickListener
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        mOnSongListener.onSongClick(getAdapterPosition());
    }
}
