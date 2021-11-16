package com.example.taskmaster;

import android.content.Intent;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amplifyframework.datastore.generated.model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskAdabter extends RecyclerView.Adapter<TaskAdabter.TaskViewHolder> {
    List<com.amplifyframework.datastore.generated.model.Task> listTask = new ArrayList<>();

    public TaskAdabter(List<com.amplifyframework.datastore.generated.model.Task> listTask) {
        this.listTask = listTask;
    }

    public static class TaskViewHolder extends RecyclerView.ViewHolder {

        public Task task;
        View itemview;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemview = itemView;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.i("my Adapter", "Element "+ getAdapterPosition() + " clicked");
                    Intent goToTask = new Intent(view.getContext(), Taskdetail.class);
                    goToTask.putExtra("taskName",task.getTitle());
                    goToTask.putExtra("body",task.getBody());
                    goToTask.putExtra("state",task.getState());
                    view.getContext().startActivity(goToTask);
                }
            });

        }


    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_task, viewGroup , false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder taskViewHolder, int i) {
        taskViewHolder.task=listTask.get(i);
        TextView title = taskViewHolder.itemView.findViewById(R.id.titlefra);
        TextView body = taskViewHolder.itemView.findViewById(R.id.body);
        TextView state = taskViewHolder.itemView.findViewById(R.id.state);

        title.setText(taskViewHolder.task.getTitle());
        body.setText(taskViewHolder.task.getBody());
        state.setText(taskViewHolder.task.getState());

    }

    @Override
    public int getItemCount() {
        return listTask.size();
    }


}
