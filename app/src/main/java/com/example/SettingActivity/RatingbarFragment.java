package com.example.SettingActivity;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.LoginPackage.R;
import com.example.MainActivity.MainActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class RatingbarFragment extends Fragment {

    RatingBar mRatingBar;
    Button submitButton;
    TextView rateTextView;

    public RatingbarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_ratingbar, container, false);

        mRatingBar = view.findViewById(R.id.ratingBar_settingFrag);
        submitButton = view.findViewById(R.id.submitRateButton_settingFrag);
        rateTextView = view.findViewById(R.id.rating_TextView_settingFrag);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rateTextView.setText("Your rating is " + mRatingBar.getRating());
                try {
                    Thread.sleep(1000);
                    onDestroy();
                    Intent goBackToSetting = new Intent(getActivity(), MainActivity.class);
                    startActivity(goBackToSetting);
                    onDestroy();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        return view;
    }

}
