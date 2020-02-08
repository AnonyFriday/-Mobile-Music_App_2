package com.example.SongPackage.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.LoginPackage.R;
import com.example.SongPackage.Entity.Song;

import java.util.ArrayList;

public class SongDataBaseHelper extends SQLiteOpenHelper {

    //Database Constants
    private static final String DATABASE_NAME = "song.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "Song";

    //Dadabase Queries For the table's column name
    private static final String COL_ID = "ID";
    private static final String COL_NAME = "NAME";
    private static final String COL_IMAGE = "IMAGE";
    private static final String COL_LINK = "LINK";

    private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_NAME + " TEXT NOT NULL,"
            + COL_IMAGE + " TEXT NOT NULL,"
            + COL_LINK + " TEXT NOT NULL" + ")";

    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    private static final String GET_ALL_STATEMENT = "SELECT * FROM " + TABLE_NAME;


    public SongDataBaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }

    /* @return  a list of all monster from the database table called monster */
    public Cursor getAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery(GET_ALL_STATEMENT, null);
    }

    public ArrayList<Song> getSongs() {
        ArrayList<Song> listSong = new ArrayList<>();

        Song song = new Song();
        song.setName("Song_1");
        song.setImageFileName("https://i.picsum.photos/id/1/32/32.jpg");
        song.setSongFile("https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3");
        listSong.add(song);

        song = new Song();
        song.setName("Song_2");
        song.setImageFileName("https://i.picsum.photos/id/2/32/32.jpg");
        song.setSongFile("https://www.soundhelix.com/examples/mp3/SoundHelix-Song-2.mp3");
        listSong.add(song);

        song = new Song();
        song.setName("Song_3");
        song.setImageFileName("https://i.picsum.photos/id/3/32/32.jpg");
        song.setSongFile("https://www.soundhelix.com/examples/mp3/SoundHelix-Song-3.mp3");
        listSong.add(song);

        song = new Song();
        song.setName("Song_4");
        song.setImageFileName("https://i.picsum.photos/id/4/32/32.jpg");
        song.setSongFile("https://www.soundhelix.com/examples/mp3/SoundHelix-Song-4.mp3");
        listSong.add(song);

        song = new Song();
        song.setName("Song_5");
        song.setImageFileName("https://i.picsum.photos/id/5/32/32.jpg");
        song.setSongFile("https://www.soundhelix.com/examples/mp3/SoundHelix-Song-5.mp3");
        listSong.add(song);

        song = new Song();
        song.setName("Song_6");
        song.setImageFileName("https://i.picsum.photos/id/6/32/32.jpg");
        song.setSongFile("https://www.soundhelix.com/examples/mp3/SoundHelix-Song-6.mp3");
        listSong.add(song);

        song = new Song();
        song.setName("Song_7");
        song.setImageFileName("https://i.picsum.photos/id/7/32/32.jpg");
        song.setSongFile("https://www.soundhelix.com/examples/mp3/SoundHelix-Song-7.mp3");
        listSong.add(song);

        song = new Song();
        song.setName("Song_8");
        song.setImageFileName("https://i.picsum.photos/id/8/32/32.jpg");
        song.setSongFile("https://www.soundhelix.com/examples/mp3/SoundHelix-Song-8.mp3");
        listSong.add(song);


        return listSong;
    }
}
