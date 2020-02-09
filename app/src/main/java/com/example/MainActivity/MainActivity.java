package com.example.MainActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.LoginPackage.R;
import com.example.SettingActivity.SettingFragment;
import com.example.SingerPackage.SingerFragment;
import com.example.SongPackage.SongFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SongFragment songFragment = new SongFragment();
        this.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayoutContainer, songFragment)
                .commit();

        ImageView userImageView = findViewById(R.id.user_ImageView_main);

        //Initialize the menu listener
        BottomNavigationView mBottomNavigationView = findViewById(R.id.bottomNavigationView);
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_singer: {
                        SingerFragment singerFragment = new SingerFragment();
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frameLayoutContainer, singerFragment)
                                .commit();

                        return true;
                    }
                    case R.id.navigation_song: {
                        SongFragment songFragment = new SongFragment();
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frameLayoutContainer, songFragment)
                                .commit();

                        return true;
                    }
                    case R.id.navigation_setting: {
                        SettingFragment settingFragment = new SettingFragment();
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frameLayoutContainer, settingFragment)
                                .commit();


                        return true;
                    }
                }

                return false;
            }
        });


    }
}
