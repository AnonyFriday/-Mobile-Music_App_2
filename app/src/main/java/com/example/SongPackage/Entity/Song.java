package com.example.SongPackage.Entity;

import java.io.Serializable;

public class Song implements Serializable {
    private String name;
    private String songFile;
    private String imageFileName;

    public static String SONG_KEY = "Song";

    public Song(){}

    //Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    //Song File
    public String getSongFile() {
        return songFile;
    }

    public void setSongFile(String songFile) {
        this.songFile = songFile;
    }


    //Image File
    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }
}