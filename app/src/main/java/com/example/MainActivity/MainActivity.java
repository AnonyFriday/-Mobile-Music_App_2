package com.example.MainActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import com.example.SettingActivity.SettingFragment;
import com.example.LoginPackage.R;
import com.example.SettingActivity.SettingFragment;
import com.example.SingerPackage.SingerFragment;
import com.example.SongPackage.Database.SongDataBaseHelper;
import com.example.SongPackage.RecyclerView.SongRecyclerViewAdapter;
import com.example.SongPackage.SongFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    BottomNavigationView mBottomNavigationView;
    static SingerFragment singerFragment;
    static SongFragment songFragment;
    static SettingFragment settingFragment;
    ImageView userImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userImageView = findViewById(R.id.user_ImageView_main);

        songFragment = new SongFragment();
        this.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayoutContainer,songFragment)
                .commit();

        //Initialize the menu listener
        mBottomNavigationView = findViewById(R.id.bottomNavigationView);
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem){
                switch (menuItem.getItemId())
                {
                    case R.id.navigation_singer:
                    {
                        singerFragment = new SingerFragment();
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frameLayoutContainer,singerFragment)
                                .commit();

                        return true;
                    }
                    case R.id.navigation_song:
                    {
                        songFragment = new SongFragment();
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frameLayoutContainer,songFragment)
                                .commit();

                        return true;
                    }
                    case R.id.navigation_setting:
                    {
                        settingFragment = new SettingFragment();
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frameLayoutContainer,settingFragment)
                                .commit();

                        return true;
                    }
                }

                return false;
            }
        });





    }
}
