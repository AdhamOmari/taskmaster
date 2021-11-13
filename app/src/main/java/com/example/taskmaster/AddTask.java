package com.example.taskmaster;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.amplifyframework.api.graphql.model.ModelMutation;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.Task;

public class AddTask extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        Button addTaskButton = findViewById(R.id.addTasktodb);
//        addTaskButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(),"submitted!", Toast.LENGTH_SHORT).show();
//            }
//        });


        Button addStudentBTN = findViewById(R.id.addTasktodb);
        addStudentBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                EditText title = findViewById(R.id.titlePerson);
                String titlefiled = title.getText().toString();

                EditText body = findViewById(R.id.bodydb);
                String bodyfiled = body.getText().toString();


                EditText descriptionFiled = findViewById(R.id.descriptiondb);
                String descr = descriptionFiled.getText().toString();
                Toast.makeText(getApplicationContext(),"submitted!", Toast.LENGTH_SHORT).show();


                com.amplifyframework.datastore.generated.model.Task todo = Task.builder()
                        .title(titlefiled)
                        .body(bodyfiled)
                        .state(descr)
                        .build();

                Amplify.API.mutate(
                        ModelMutation.create(todo),
                        response -> Log.i("AddTask", "Added Todo with id: " + response.getData().getId()),
                        error -> Log.e("AddTask", "Create failed", error)
                );
//                Task task = new Task(bodyfiled, descr, titlefiled);
//                Long addedTaskID = AppDatabase.getInstance(getApplicationContext()).taskDao().insertTask(task);
//
//                System.out.println(
//                        "++++++++++++++++++++++++++++++++++++++++++++++++++" +
//                                " Student ID : " + addedTaskID
//
//                );


            }
        });


    }
}