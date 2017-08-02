package com.dumbaz.skatespot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText etPassword = (EditText) findViewById(R.id.Password);
        final EditText etUsername = (EditText) findViewById(R.id.Username);
        final Button bLogin = (Button) findViewById(R.id.LoginButton);
        final TextView registerLink = (TextView) findViewById(R.id.LinkRegister);
        final TextView mapLink = (TextView) findViewById(R.id.etMap);

        registerLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);
            }
        });

        mapLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(LoginActivity.this, MapsActivity.class);
                LoginActivity.this.startActivity(registerIntent);
            }
        });
    }
}
