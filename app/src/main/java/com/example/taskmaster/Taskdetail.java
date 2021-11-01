package com.example.taskmaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Taskdetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taskdetail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        String taskName = intent.getExtras().getString("taskName");
        TextView taskTitle = findViewById(R.id.textView5);
        taskTitle.setText(taskName);
    }
}