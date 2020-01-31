package com.example.PlaySongActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.LoginPackage.R;

import java.io.IOException;

public class playSongFunction extends AppCompatActivity {

    Button playButton;
    TextView elapseTimeLabel, remainingTimeLabel;
    String myUri;
    Integer totalTimeOfSong;
    SeekBar positioningTimeSeekBar, volumnSeekBar;
    ImageView choosedSongImageView;
    MediaPlayer myMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_song_function);


        initComponents();
        try {
            initMediaPlayer(); //this is mandatory
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initMediaPlayer() throws IOException {
        myMediaPlayer = new MediaPlayer();
        myUri = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-8.mp3";
        //myMediaPlayer = MediaPlayer.create(this, R.raw.song_1);
        myMediaPlayer.setDataSource(myUri);

        myMediaPlayer.prepare();
        myMediaPlayer.start();
        myMediaPlayer.setLooping(true);
        myMediaPlayer.seekTo(0);
        myMediaPlayer.setVolume(0.5f, 0.5f);
        totalTimeOfSong = myMediaPlayer.getDuration();

        positioningTimeSeekBar.setMax(totalTimeOfSong);
        positioningTimeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    myMediaPlayer.seekTo(progress);
                    positioningTimeSeekBar.setProgress(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!myMediaPlayer.isPlaying()) {
                    myMediaPlayer.start();
                    playButton.setBackgroundResource(R.drawable.stop_button);
                } else {
                    myMediaPlayer.stop();
                    playButton.setBackgroundResource(R.drawable.play_button);
                }

            }
        });

        volumnSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float volumeNum = progress / 100f;
                myMediaPlayer.setVolume(volumeNum, volumeNum);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //Thread ( Update position Bar and timeLabel )
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (myMediaPlayer != null) //infinite loop
                {
                    try {
                        Message message = new Message();
                        message.what = myMediaPlayer.getCurrentPosition(); // get the current position of the song and pass it to the message
                        handler.sendMessage(message);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();

    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            int currentTime = msg.what; // current time is passing

            //update position bar
            positioningTimeSeekBar.setProgress(currentTime);

            //update Label Time
            String elapsedTime = createTimeLable(currentTime);
            elapseTimeLabel.setText(elapsedTime);

            String remainingTime = createTimeLable(totalTimeOfSong - currentTime);
            remainingTimeLabel.setText("- " + remainingTime);
        }
    };

    //for calculating the remaining time and the elapsetime
    private String createTimeLable(int currentPosition) {
        String timeLabel = "";
        int minute = currentPosition / 1000 / 60;
        int sec = currentPosition / 1000 % 60; // ( is gonna be on the range of 1 to 59 of 60s

        timeLabel = minute + ":"; // example 1:, 2:, 3:, 4:,...
        if (sec < 10) {
            timeLabel += "0"; //example 1:01, 1:02, 1:03,...,1.09
        }
        timeLabel += sec; // 1:10, 1:11, 1:12,...

        return timeLabel;
    }

    private void initComponents() {
        playButton = findViewById(R.id.playButton_Button_playSong);
        elapseTimeLabel = findViewById(R.id.elapsedTimeLabel_TextView_playSong);
        remainingTimeLabel = findViewById(R.id.remainingTimeLabel_TextView_playSong);
        positioningTimeSeekBar = findViewById(R.id.remainingTime_SeekBar_playSong);
        volumnSeekBar = findViewById(R.id.volumnSeekBar_playSong);

        choosedSongImageView = findViewById(R.id.songImage_imageView_songPlay);
    }
}
