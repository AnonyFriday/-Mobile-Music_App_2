package com.example.SingerPackage;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ConstantKey.ActitiviyConstantKey;
import com.example.LoginPackage.R;
import com.example.PlaySongActivity.playSongFunction;
import com.example.SingerPackage.Database.SingerDataBaseHelper;
import com.example.SingerPackage.Entity.Singer;
import com.example.SingerPackage.RecyclerView.SingerRecyclerViewAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class SingerFragment extends Fragment implements SingerRecyclerViewAdapter.OnSingerListener {

    private SingerRecyclerViewAdapter singerAdapter;
    private RecyclerView singerRecyclerView;
    private SingerDataBaseHelper mSingerDataBaseHelper;


    public SingerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return recyclerViewComponents(inflater, container);
    }

    private View recyclerViewComponents(LayoutInflater inflater, ViewGroup container) {

        View view = inflater.inflate(R.layout.fragment_singer, container, false);

        singerRecyclerView = view.findViewById(R.id.recyclerView_SingerActivity);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 1, RecyclerView.VERTICAL, false);
        singerRecyclerView.setLayoutManager(gridLayoutManager);


        mSingerDataBaseHelper = new SingerDataBaseHelper();
        singerAdapter = new SingerRecyclerViewAdapter(getActivity(), mSingerDataBaseHelper.getSingers(), this);
        singerRecyclerView.setAdapter(singerAdapter);
        return view;
    }

    @Override
    public void onSingerClick(int position) {
        //I currently
        Intent goToplaySongFragment = new Intent(getActivity(), playSongFunction.class);
        goToplaySongFragment.putExtra(Singer.SINGER_KEY, mSingerDataBaseHelper.getSingers().get(position));

        startActivityForResult(goToplaySongFragment, ActitiviyConstantKey.SINGER_SCREEN_REQUEST_CODE);
    }
}
