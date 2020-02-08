package com.example.SongPackage;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.constraintlayout.widget.Constraints;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ConstantKey.ActitiviyConstantKey;
import com.example.PlaySongActivity.playSongFunction;
import com.example.LoginPackage.R;
import com.example.SongPackage.Database.SongDataBaseHelper;
import com.example.SongPackage.Entity.Song;
import com.example.SongPackage.RecyclerView.SongRecyclerViewAdapter;


public class SongFragment extends Fragment implements SongRecyclerViewAdapter.OnSongListener {


    public SongFragment() {
        // Required empty public constructor
    }

    SongRecyclerViewAdapter songAdapter;
    RecyclerView songRecyclerView;
    Song song;
    SongDataBaseHelper songDataBaseHelper;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return recyclerViewComponents(inflater, container);
    }

    private View recyclerViewComponents(LayoutInflater inflater, ViewGroup container) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_song, container, false);

        //recycler View
        songRecyclerView = view.findViewById(R.id.recyclerView_SongActivity);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 1, GridLayoutManager.VERTICAL, false);
        songRecyclerView.setLayoutManager(gridLayoutManager);
        //TODO pass this to the onSongListener
        songDataBaseHelper = new SongDataBaseHelper(getActivity());
        songAdapter = new SongRecyclerViewAdapter(songDataBaseHelper.getSongs(), getActivity(),this);
        songRecyclerView.setAdapter(songAdapter);
        return view;
    }


    @Override
    public void onSongClick(int position) {
        Log.d("Clicked","Element has been clicked");

        Intent goToPlaySongActivity = new Intent(getActivity(), playSongFunction.class);
        goToPlaySongActivity.putExtra(Song.SONG_KEY,songDataBaseHelper.getSongs().get(position));
        startActivityForResult(goToPlaySongActivity, ActitiviyConstantKey.SONG_LIST_SCREEN_REQUEST_CODE);



       // intent.putExtra("Name", mSongDataBaseHelper.getSongs().get(position));
       // startActivity(intent);
    }
}
