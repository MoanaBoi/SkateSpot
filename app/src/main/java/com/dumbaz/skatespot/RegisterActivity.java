package com.dumbaz.skatespot;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText etEmail = (EditText) findViewById(R.id.etEmail);
        final EditText etUsername = (EditText) findViewById(R.id.etUsername);
        final EditText etName = (EditText) findViewById(R.id.etName);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final EditText etRetypePassword = (EditText) findViewById(R.id.etRetypePassword);
        final Button bRegister = (Button) findViewById(R.id.Register);

        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String name = etName.getText().toString();
                final String username = etUsername.getText().toString();
                final String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                final String retypePassword = etRetypePassword.getText().toString();

                if (!password.equals(retypePassword)) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                    builder.setMessage("You entered two different passwords")
                            .setNegativeButton("Rerty", null)
                            .create()
                            .show();
                }
                else {
                        Response.Listener<String> responseListener = new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                etUsername.setText("");
                                etName.setText("");
                                etPassword.setText("");
                                etRetypePassword.setText("");
                                etEmail.setText("");
                                JSONObject json = new JSONObject(response);
                                boolean success = json.getBoolean("success");
                                if (success) {
                                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                    RegisterActivity.this.startActivity(intent);
                                } else {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                    builder.setMessage("Failed to register ! please try again later")
                                            .setNegativeButton("Rerty", null)
                                            .create()
                                            .show();
                                }
                            } catch (JSONException e) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                builder.setMessage(response)
                                        .setNegativeButton("Json error", null)
                                        .create()
                                        .show();
                                e.printStackTrace();
                            }
                        }
                    };

                    HashMD5 hash = new HashMD5(password);
                    password = hash.getHashPassword();
                    RegisterRequest registerRequest = new RegisterRequest(name, username, email, password, responseListener);
                    RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                    queue.add(registerRequest);
                }
            }
        });
    }
}
