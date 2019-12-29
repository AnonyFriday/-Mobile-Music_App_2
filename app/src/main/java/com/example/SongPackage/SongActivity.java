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

    SongDataBaseHelper songDatabase;
    SongRecyclerViewAdapter songAdapter;
    List<Song> listSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);




        RecyclerView songRecyclerView = findViewById(R.id.songRecyclerView_recycleview_song);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        songRecyclerView.setLayoutManager(linearLayoutManager);

        songDatabase = new SongDataBaseHelper(this);
        listSong = songDatabase.getSongs(); //arraylist

        songAdapter = new SongRecyclerViewAdapter(listSong,this);

        songRecyclerView.setAdapter(songAdapter);


    }
}
