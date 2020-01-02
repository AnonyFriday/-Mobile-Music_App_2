package com.example.SongPackage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.LoginPackage.R;
import com.example.SongPackage.Database.SongDataBaseHelper;
import com.example.SongPackage.Entity.Song;
import com.example.SongPackage.RecyclerView.SongRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class SongActivity extends AppCompatActivity {

    SongRecyclerViewAdapter songAdapter;
    RecyclerView songRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);

        songRecyclerView = findViewById(R.id.songRecyclerView_recycleview_song);
        songRecyclerView.setLayoutManager(new LinearLayoutManager(SongActivity.this));

        songAdapter = new SongRecyclerViewAdapter(new SongDataBaseHelper(this).getSongs(),this);
        songRecyclerView.setAdapter(songAdapter);

    }
}
