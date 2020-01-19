package com.example.SongPackage;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.HomeActivity.playSongFunction;
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
    SongDataBaseHelper mSongDataBaseHelper;
    Song song;

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
        songAdapter = new SongRecyclerViewAdapter(new SongDataBaseHelper(getActivity()).getSongs(), getActivity(),this);
        songRecyclerView.setAdapter(songAdapter);
        return view;
    }


    @Override
    public void onSongClick(int position) {
        Log.d("Clicked","Element has been clicked");

        Intent intent = new Intent(getActivity(), playSongFunction.class);
       // intent.putExtra("Name", mSongDataBaseHelper.getSongs().get(position));
        startActivity(intent);
    }
}
