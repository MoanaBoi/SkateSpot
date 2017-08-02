package com.dumbaz.skatespot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView etUsername = (TextView) findViewById(R.id.etUsername);
        final TextView etEmail = (TextView) findViewById(R.id.etEmail);
        final TextView welcomeMessage = (TextView) findViewById(R.id.WelcomeMessage);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String username = intent.getStringExtra("username");
        String email = intent.getStringExtra("email");

        String message = "Welcome to the user area " + name;
        welcomeMessage.setText(message);
        etUsername.setText(username);
        etEmail.setText(email);
    }
}
