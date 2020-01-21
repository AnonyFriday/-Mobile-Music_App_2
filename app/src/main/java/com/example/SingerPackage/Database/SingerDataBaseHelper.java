package com.example.SingerPackage.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.example.LoginPackage.R;
import com.example.SingerPackage.Entity.Singer;
import com.example.SingerPackage.RecyclerView.SingerViewHolder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SingerDataBaseHelper{


    public ArrayList<Singer> getSingers(){

        ArrayList<Singer> singerArrayList = new ArrayList<>();

        Singer singer = new Singer();
        singer.setName("Vu Kim Duy");
        singer.setImageFileName(R.drawable.song_1);
        singerArrayList.add(singer);

        singer = new Singer();
        singer.setName("Vu Kim Duy");
        singer.setImageFileName(R.drawable.song_1);
        singerArrayList.add(singer);

        singer = new Singer();
        singer.setName("Vu Kim Duy");
        singer.setImageFileName(R.drawable.song_1);
        singerArrayList.add(singer);


        singer = new Singer();
        singer.setName("Vu Kim Duy");
        singer.setImageFileName(R.drawable.song_1);
        singerArrayList.add(singer);


        singer = new Singer();
        singer.setName("Vu Kim Duy");
        singer.setImageFileName(R.drawable.song_1);
        singerArrayList.add(singer);


        singer = new Singer();
        singer.setName("Vu Kim Duy");
        singer.setImageFileName(R.drawable.song_1);
        singerArrayList.add(singer);


        return singerArrayList;
    }

}
