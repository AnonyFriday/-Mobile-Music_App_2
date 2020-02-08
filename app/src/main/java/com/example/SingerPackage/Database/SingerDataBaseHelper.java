package com.example.SingerPackage.Database;

import com.example.SingerPackage.Entity.Singer;

import java.util.ArrayList;

public class SingerDataBaseHelper {


    public ArrayList<Singer> getSingers() {

        ArrayList<Singer> singerArrayList = new ArrayList<>();

        Singer singer = new Singer();
        singer.setName("Vu Kim Duy");
        singer.setImageFileName("https://i.picsum.photos/id/20/32/32.jpg");
        singer.setSingerFileSong("https://www.soundhelix.com/examples/mp3/SoundHelix-Song-10.mp3");
        singerArrayList.add(singer);

        singer = new Singer();
        singer.setName("Ed Sheeran");
        singer.setImageFileName("https://i.picsum.photos/id/21/32/32.jpg");
        singer.setSingerFileSong("https://www.soundhelix.com/examples/mp3/SoundHelix-Song-11.mp3");
        singerArrayList.add(singer);

        singer = new Singer();
        singer.setName("Westlife");
        singer.setImageFileName("https://i.picsum.photos/id/22/32/32.jpg");
        singer.setSingerFileSong("https://www.soundhelix.com/examples/mp3/SoundHelix-Song-12.mp3");
        singerArrayList.add(singer);


        singer = new Singer();
        singer.setName("HardCore");
        singer.setImageFileName("https://i.picsum.photos/id/23/32/32.jpg");
        singer.setSingerFileSong("https://www.soundhelix.com/examples/mp3/SoundHelix-Song-13.mp3");
        singerArrayList.add(singer);


        singer = new Singer();
        singer.setName("StreetBoy");
        singer.setImageFileName("https://i.picsum.photos/id/24/32/32.jpg");
        singer.setSingerFileSong("https://www.soundhelix.com/examples/mp3/SoundHelix-Song-14.mp3");
        singerArrayList.add(singer);


        singer = new Singer();
        singer.setName("Michale");
        singer.setImageFileName("https://i.picsum.photos/id/25/32/32.jpg");
        singer.setSingerFileSong("https://www.soundhelix.com/examples/mp3/SoundHelix-Song-15.mp3");
        singerArrayList.add(singer);

        return singerArrayList;
    }

}
