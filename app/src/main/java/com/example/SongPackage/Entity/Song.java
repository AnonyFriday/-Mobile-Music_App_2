package com.example.SongPackage.Entity;

import java.io.Serializable;

public class Song implements Serializable {
    private String name;
    private int imageFileName;
    // public static String SONG_KEY = "Song";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(int imageFileName) {
        this.imageFileName = imageFileName;
    }
}