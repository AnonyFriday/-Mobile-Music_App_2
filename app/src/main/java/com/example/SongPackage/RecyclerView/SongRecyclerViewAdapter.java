package com.example.SongPackage.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.LoginPackage.R;
import com.example.SongPackage.Entity.Song;

import java.util.List;

public class SongRecyclerViewAdapter extends RecyclerView.Adapter<SongViewHolder> {

    private List<Song> mSongs;
    private Context mContext;

    public SongRecyclerViewAdapter(List<Song> songs, Context context) {
        mSongs = songs;
        mContext = context;
    }

    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.recycler_song_view,parent,false);

        return new SongViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder songViewHolderholder, int position) {

        songViewHolderholder.songNameTextView.setText(mSongs.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mSongs.size();
    }
}
