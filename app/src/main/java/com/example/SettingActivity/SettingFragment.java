package com.example.SettingActivity;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.LoginPackage.LoginActivity;
import com.example.LoginPackage.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends Fragment {


    public SettingFragment() {
        // Required empty public constructor
    }

    Button logoutButton;
    Button rateButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return settingFragmentView(inflater,container);
    }

    private View settingFragmentView(LayoutInflater inflater, ViewGroup container) {

        View view = inflater.inflate(R.layout.fragment_setting,container,false);

        logoutButton = view.findViewById(R.id.logout_Button_setting);
        rateButton = view.findViewById(R.id.rate_Button_settting);

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                onDestroy();
            }
        });

        //TODO change to the rateActivity which hasn't been done yet

        return view;
    }



}
