package com.example.testlogic.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.testlogic.models.User;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM Users")
    LiveData<List<User>> getUsers();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<User> users);

    @Query("SELECT * FROM Users WHERE id = :userId")
    User getUserDetail(int userId);
}
