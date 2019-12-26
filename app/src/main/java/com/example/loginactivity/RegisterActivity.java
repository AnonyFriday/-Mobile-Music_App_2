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

public class RegisterActivity extends AppCompatActivity {

    EditText mTextUsername;
    EditText mTextPassword;
    EditText mTextConfirmPassword;
    Button mButtonRegister;
    TextView mTextViewLogin;
    DataBaseHelper database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mTextUsername = findViewById(R.id.username_editText_register);
        mTextPassword = findViewById(R.id.password_editText_register);
        mTextConfirmPassword = findViewById(R.id.confirmPassword_editText_register);
        mButtonRegister = findViewById(R.id.register_button_register);
        mTextViewLogin = findViewById(R.id.login_textView_register);
        database = new DataBaseHelper(this);

        mTextViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(loginIntent);
            }
        });

        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = mTextUsername.getText().toString().trim();
                String password = mTextPassword.getText().toString().trim();
                String confirmPassword = mTextConfirmPassword.getText().toString().trim();

                if (confirmPassword.equals(password)) {
                    long result = database.addUser(username, password);
                    if (result > 0) {

                        Toast.makeText(RegisterActivity.this, "Successfully Registered", Toast.LENGTH_SHORT).show();
                        Intent movetoLogin = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(movetoLogin);
                    } else
                        Toast.makeText(RegisterActivity.this, "Registeration Error", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(RegisterActivity.this, "Password is not matching", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
