package com.example.SongPackage.RecyclerView;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.LoginPackage.R;
import com.example.SongPackage.Entity.Song;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SongRecyclerViewAdapter extends RecyclerView.Adapter<SongViewHolder> {

    private ArrayList<Song> mSongs;
    private Context mContext;
    private OnSongListener mOnSongListener;

    //TODO add the OnSongListener data type
    public SongRecyclerViewAdapter(ArrayList<Song> songs, Context context, OnSongListener onSongListener) {
        mSongs = songs;
        mContext = context;
        this.mOnSongListener = onSongListener;
    }

    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_song_view, null);
        return new SongViewHolder(view, mOnSongListener);

    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder songViewHolderholder, int position) {

        songViewHolderholder.songNameTextView.setText(mSongs.get(position).getName());

        final Song song = mSongs.get(position);
        Picasso.get()
                .load(song.getImageFileName())
                .into(songViewHolderholder.songImageView);

        //songViewHolderHolder.mOnSongListener.onSongClick(position);


    }

    @Override
    public int getItemCount() {
        return mSongs.size();
    }

    //to create the click for each element
    public interface OnSongListener {
        void onSongClick(int position);
    }
}
