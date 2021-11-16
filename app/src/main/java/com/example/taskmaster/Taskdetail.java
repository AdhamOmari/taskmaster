package com.example.taskmaster;

import android.content.Intent;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Taskdetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_taskdetail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Intent intent=getIntent();
        String title=intent.getExtras().getString("taskName");
        String body=intent.getExtras().getString("body");
        String state=intent.getExtras().getString("state");
        TextView taskTitleView =findViewById(R.id.titlede);
        TextView taskBodyView =findViewById(R.id.bodyde);
        TextView taskStateView =findViewById(R.id.statede);
        taskTitleView.setText("Task Title:  "+title);
        taskBodyView.setText("Task Body:  "+body);
        taskStateView.setText("Task State:  "+state);

    }
//    @Override
//    protected void onStart() {
//        super.onStart();
//        Intent intent = getIntent();
//        String taskName = intent.getExtras().getString("taskName");
//        TextView taskTitle = findViewById(R.id.titlede);
//
//        taskTitle.setText(taskName);
//
//        String taskBody = intent.getExtras().getString("body");
//        TextView body = findViewById(R.id.bodyde);
//        body.setText(taskBody);
//
//        String taskstate = intent.getExtras().getString("state");
//        TextView state = findViewById(R.id.statede);
//        state.setText(taskstate);
//    }
}