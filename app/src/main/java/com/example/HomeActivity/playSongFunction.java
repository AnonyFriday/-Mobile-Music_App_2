package com.example.HomeActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.LoginPackage.R;

public class playSongFunction extends AppCompatActivity {

    Button playButton;
    TextView elapseTimeTextView, remainingTimeTextView;

    Integer totalTimeOfSong;
    SeekBar remainingTimeSeekBar, volumnSeekBar;
    ImageView choosedSongImageView;
    MediaPlayer myMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_song_function);

        initComponents();
        initMediaPlayer(); //this is mandatory
    }

    private void initMediaPlayer() {
    }


    private void initComponents() {
        playButton = findViewById(R.id.playButton_Button_playSong);
        elapseTimeTextView = findViewById(R.id.elapsedTimeLabel_TextView_playSong);
        remainingTimeTextView = findViewById(R.id.remainingTimeLabel_TextView_playSong);

        remainingTimeSeekBar = findViewById(R.id.remainingTime_SeekBar_playSong);
        volumnSeekBar = findViewById(R.id.volumnSeekBar_playSong);

        choosedSongImageView = findViewById(R.id.songImage_imageView_songPlay);
    }
}
