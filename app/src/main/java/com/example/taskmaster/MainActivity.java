package com.example.taskmaster;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.preference.PreferenceManager;
import android.os.Bundle;


import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.amplifyframework.AmplifyException;
import com.amplifyframework.api.aws.AWSApiPlugin;
import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.Task;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonOne = findViewById(R.id.button);
        RecyclerView allTasks = findViewById(R.id.recyclerView);




        try {

            Amplify.addPlugin(new AWSApiPlugin());
            Amplify.configure(getApplicationContext());

            Log.i("Tutorial", "Initialized Amplify");
        } catch (AmplifyException error) {
            Log.e("Tutorial", "Could not initialize Amplify", error);
        }



        Handler handler =new Handler(Looper.getMainLooper(), new Handler.Callback() {
            @Override
            public boolean handleMessage(@NonNull Message message) {
                allTasks.getAdapter().notifyDataSetChanged();
                return false;
            }
        });

        List <Task> tasks= new ArrayList<Task>();

        Amplify.API.query(
                ModelQuery.list(com.amplifyframework.datastore.generated.model.Task.class),
                response -> {
                    for (Task taskTodo : response.getData()) {
                        tasks.add(taskTodo);
                    }
                    handler.sendEmptyMessage(1);
                },
                error -> Log.e("MyAmplifyApp", error.toString(), error)
        );

        allTasks.setLayoutManager(new LinearLayoutManager(this));
        allTasks.setAdapter(new TaskAdabter(tasks));


        //        allStudentRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        allStudentRecyclerView.setAdapter(new TaskAdabter(tasksFromDb));










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

//
//        ArrayList<Task> taskList = new ArrayList<Task>();
//        taskList.add(new Task("task1","solve your lab","inprogress"));
//        taskList.add(new Task("task2","solve your read"," complete"));
//        taskList.add(new Task("task3","solve your career"," assigned"));
//
//
//        List<Task> taskDb = AppDatabase.getInstance(getApplicationContext()).taskDao().getAll();
//        ArrayList<Task> tasksFromDb = new ArrayList<>();
//        for(Task task:taskDb){
//            tasksFromDb.add(task);
//        }



        // set a layout manager
//        allStudentRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        allStudentRecyclerView.setAdapter(new TaskAdabter(tasksFromDb));




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