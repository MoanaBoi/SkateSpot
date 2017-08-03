package com.dumbaz.skatespot;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SurfaceView userMenu = (SurfaceView) findViewById(R.id.userMenu);
        userMenu.setBackgroundColor(Color.GRAY);

        Button mapButton = (Button) findViewById(R.id.mapButton);
        mapButton.setVisibility(View.VISIBLE);
        mapButton.setBackgroundColor(Color.TRANSPARENT);
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        Button settingsButton = (Button) findViewById(R.id.settingsButton);
        settingsButton.setVisibility(View.VISIBLE);
        settingsButton.setBackgroundColor(Color.TRANSPARENT);
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

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
