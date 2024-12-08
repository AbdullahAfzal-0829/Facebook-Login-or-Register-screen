package com.example.task1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText username = findViewById(R.id.username);
        EditText email = findViewById(R.id.email);
        EditText password = findViewById(R.id.password);
        Button registerButton = findViewById(R.id.register);

        SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        registerButton.setOnClickListener(view -> {
            String uname = username.getText().toString().trim();
            String eml = email.getText().toString().trim();
            String pwd = password.getText().toString().trim();

            if (uname.isEmpty() || eml.isEmpty() || pwd.isEmpty()) {
                Toast.makeText(this, "All fields are required!", Toast.LENGTH_SHORT).show();
            }
            else
            {
                editor.putString("username", uname);
                editor.putString("email", eml);
                editor.putString("password", pwd);
                editor.apply();

                Toast.makeText(this, "Registration Successful!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, loginactivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
