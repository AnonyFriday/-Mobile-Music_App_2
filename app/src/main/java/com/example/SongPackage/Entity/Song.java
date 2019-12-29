package com.example.SongPackage.Entity;

import java.io.Serializable;

public class Song implements Serializable {
    private Long id;
    private String name;
    private String imageFileName;
    // public static String SONG_KEY = "Song";


    public Song(Long id ,String name,String imageFileName) {
        this.id = id;
        this.name = name;
        this.imageFileName = imageFileName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
