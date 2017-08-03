package com.dumbaz.skatespot;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        SurfaceView userMenu = (SurfaceView) findViewById(R.id.userMenu);
        userMenu.setBackgroundColor(Color.GRAY);

        Button mapButton = (Button) findViewById(R.id.mapButton);
        mapButton.setVisibility(View.VISIBLE);
        mapButton.setBackgroundColor(Color.TRANSPARENT);
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingsActivity.this, MapsActivity.class);
                SettingsActivity.this.startActivity(intent);
            }
        });

        Button userButton = (Button) findViewById(R.id.userButton);
        userButton.setVisibility(View.VISIBLE);
        userButton.setBackgroundColor(Color.TRANSPARENT);
        userButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingsActivity.this, MainActivity.class);
                SettingsActivity.this.startActivity(intent);
            }
        });
    }
}
