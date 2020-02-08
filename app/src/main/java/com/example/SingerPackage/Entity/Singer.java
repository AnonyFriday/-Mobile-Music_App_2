package com.example.SingerPackage.Entity;

import java.io.Serializable;

public class Singer implements Serializable {
    private String name;
    private String imageFileName;
    private String singerFileSong;

    public String getSingerFileSong() {
        return singerFileSong;
    }

    public void setSingerFileSong(String singerFileSong) {
        this.singerFileSong = singerFileSong;
    }

    public static final String SINGER_KEY = "SINGER";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }
}
