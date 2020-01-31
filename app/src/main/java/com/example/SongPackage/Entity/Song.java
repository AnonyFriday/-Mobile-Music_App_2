package com.example.SongPackage.Entity;

import java.io.Serializable;

public class Song implements Serializable {
    private String name;
    private String songFile;
    private String imageFileName;

    public static String SONG_KEY = "Song";

    public Song(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSongFile() {
        return songFile;
    }

    public void setSongFile(String songFile) {
        this.songFile = songFile;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }
}