package com.example.SongPackage.RecyclerView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.LoginPackage.R;
import com.example.SongPackage.Entity.Song;

public class SongViewHolder extends RecyclerView.ViewHolder {

    public final ImageView songImageView;
    public final TextView songNameTextView;

    public SongViewHolder(@NonNull View itemView) {
        super(itemView);

        songImageView = itemView.findViewById(R.id.singer_imageView_song);
        songNameTextView = itemView.findViewById(R.id.songName_textView_song);
    }

    public void updateSong(Song song)
    {
        this.songImageView.setImageResource(R.drawable.ic_launcher_background);
        this.songNameTextView.setText("Hello");
    }
}
