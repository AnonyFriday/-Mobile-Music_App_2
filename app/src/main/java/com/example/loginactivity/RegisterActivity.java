package com.example.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    EditText mTextUsername;
    EditText mTextPassword;
    EditText mTextConfirmPassword;
    Button mButtonRegister;
    TextView mTextViewLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mTextUsername = findViewById(R.id.username_editText_register);
        mTextPassword = findViewById(R.id.password_editText_register);
        mTextConfirmPassword = findViewById(R.id.confirmPassword_editText_register);
        mButtonRegister = findViewById(R.id.register_button_register);
        mTextViewLogin = findViewById(R.id.login_textView_register);

        mTextViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(loginIntent);
            }
        });
    }
}
