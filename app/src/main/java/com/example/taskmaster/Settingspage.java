package com.example.taskmaster;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Settingspage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settingspage);

        Button saveButton = findViewById(R.id.SaveName);
        saveButton.setOnClickListener((View -> {
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(Settingspage.this);
            SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
            EditText usernameInput = findViewById(R.id.Name);
            String username = usernameInput.getText().toString();
            sharedPreferencesEditor.putString("username",username);
            sharedPreferencesEditor.apply();
        }));

    }



}