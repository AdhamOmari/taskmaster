package com.example.taskmaster;

import android.content.Context;
import android.provider.Contacts;
import android.provider.ContactsContract;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Task.class},version = 1)
public abstract  class AppDatabase extends RoomDatabase {
     public abstract TaskDao taskDao();
    public static AppDatabase appDatabase;
    public AppDatabase(){

    }


    public static AppDatabase getInstance(Context context){
        if (appDatabase==null){
            appDatabase= Room.databaseBuilder(context ,
                    AppDatabase.class,
                    "TaskDb").allowMainThreadQueries().build();
        }
        return appDatabase;

    }
}

