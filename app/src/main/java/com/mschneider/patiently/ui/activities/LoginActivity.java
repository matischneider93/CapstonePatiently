package com.mschneider.patiently.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mschneider.patiently.R;

public class LoginActivity extends AppCompatActivity {
    private boolean loggedIn;
    EditText userNameText;
    EditText passwordText;
    Button loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userNameText = findViewById(R.id.userNameTextField);
        passwordText = findViewById(R.id.passwordTextField);
        loginButton = findViewById(R.id.loginButton);



        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userNameText.getText().toString().isEmpty()){
                    loggedIn = false;
                } else {
                    loggedIn = true;
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    intent.putExtra("login_status", loggedIn);
                    startActivity(intent);
                }
            }
        });
    }
}