package com.example.testlogic.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.testlogic.database.dao.UserDao;
import com.example.testlogic.models.User;

@Database(entities = {User.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao userDao();

    private static AppDatabase instance;

    public static synchronized AppDatabase getInstance(Context context){
        if(instance == null ){
            instance = Room.databaseBuilder(context,
                    AppDatabase.class,"test_logic").build();
        }
        return instance;
    }


}
