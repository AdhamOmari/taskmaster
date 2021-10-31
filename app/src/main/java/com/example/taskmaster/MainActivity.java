package com.example.taskmaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonOne = findViewById(R.id.button);
        buttonOne.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Button Clicked");

                Intent activity2Intent = new Intent(getApplicationContext(), AddTask.class);
                startActivity(activity2Intent);
            }
        });
        Button allTasksBtn = findViewById(R.id.button2);
        allTasksBtn.setOnClickListener(view -> {
            Intent intent1 = new Intent(MainActivity.this, AllTasks.class);
            startActivity(intent1);
        });
    }
}