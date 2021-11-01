package com.example.taskmaster;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
        Button sitting = findViewById(R.id.Settings);
        sitting.setOnClickListener(view -> {
            Intent intent1 = new Intent(MainActivity.this, Settingspage.class);
            startActivity(intent1);
        });
        Button labButton = findViewById(R.id.Code);
        labButton.setOnClickListener((view -> {
            String taskTitle = labButton.getText().toString();
            Intent goToTaskDetail = new Intent(MainActivity.this , Taskdetail.class);
            goToTaskDetail.putExtra("taskName", taskTitle);
            startActivity(goToTaskDetail);
        }));
        Button LAB = findViewById(R.id.LAB);
        LAB.setOnClickListener((view -> {
            String taskTitle = LAB.getText().toString();
            Intent goToTaskDetail = new Intent(MainActivity.this , Taskdetail.class);
            goToTaskDetail.putExtra("taskName", taskTitle);
            startActivity(goToTaskDetail);
        }));

        Button prep = findViewById(R.id.prep);
        prep.setOnClickListener((view -> {
            String taskTitle = prep.getText().toString();
            Intent goToTaskDetail = new Intent(MainActivity.this , Taskdetail.class);
            goToTaskDetail.putExtra("taskName", taskTitle);
            startActivity(goToTaskDetail);
        }));

    }
    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        String username = sharedPreferences.getString("username", "Your");
        TextView userTasks = findViewById(R.id.textView8);
        userTasks.setText(username);
    }

}