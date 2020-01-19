package com.example.MainActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.AlbumPackage.AlbumFragment;
import com.example.LoginPackage.R;
import com.example.SingerPackage.SingerFragment;
import com.example.SongPackage.Database.SongDataBaseHelper;
import com.example.SongPackage.RecyclerView.SongRecyclerViewAdapter;
import com.example.SongPackage.SongFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    BottomNavigationView mBottomNavigationView;
    static SingerFragment singerFragment;
    static SongFragment songFragment;
    static AlbumFragment albumFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                    case R.id.navigation_albums:
                    {
                        albumFragment = new AlbumFragment();
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frameLayoutContainer,albumFragment)
                                .commit();

                        return true;
                    }
                }

                return false;
            }
        });





    }
}
