package com.example.taskmaster;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Settingspage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settingspage);

        Button saveButton = findViewById(R.id.SaveName);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();


        saveButton.setOnClickListener((View -> {
            TextView text = findViewById(R.id.Name);
            String name =text.getText().toString();



            RadioButton b1=findViewById(R.id.team1);
            RadioButton b2=findViewById(R.id.team2);
            RadioButton b3=findViewById(R.id.team3);

            String id = null;
            if(b1.isChecked()){
                id="1";
            }
            else if(b2.isChecked()){
                id="2";
            }
            else if(b3.isChecked()){
                id="3";
            }

            editor.putString("Team",id);
            editor.putString("EnteredText",name);
            editor.apply();

        }));

    }



}