package com.example.loginactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.Database.DataBaseHelper;
import com.example.HomeActivity.HomeActivity;

public class LoginActivity extends AppCompatActivity {
    EditText mTextUsername;
    EditText mTextPassword;
    Button mButtonLogin;
    TextView mTextViewRegister;
    DataBaseHelper database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = new DataBaseHelper(this);
        mTextUsername = findViewById(R.id.username_editText_main);
        mTextPassword = findViewById(R.id.password_editText_main);
        mButtonLogin = findViewById(R.id.login_button_main);
        mTextViewRegister = findViewById(R.id.register_textView_main);

        mTextViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(registerIntent);
            }
        });

        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = mTextUsername.getText().toString().trim();
                String password = mTextPassword.getText().toString().trim();

                boolean result = database.checkUser(username, password);
                if (result == true) {
                    Intent movetoHomeActivity = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(movetoHomeActivity);
                    Toast.makeText(LoginActivity.this, "Successfully Logged In", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(LoginActivity.this, "Failed to Log In", Toast.LENGTH_SHORT).show();

            }

        });
    }
}
