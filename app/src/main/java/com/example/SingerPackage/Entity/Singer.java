package com.example.SingerPackage.Entity;

import java.io.Serializable;

public class Singer implements Serializable {
    private String name;
    private int imageFileName;

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
