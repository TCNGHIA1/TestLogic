package com.example.testlogic.api.repository;

import androidx.lifecycle.LiveData;

import com.example.testlogic.api.ApiService;
import com.example.testlogic.api.RetrofitClient;
import com.example.testlogic.database.AppDatabase;
import com.example.testlogic.database.dao.UserDao;
import com.example.testlogic.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class UserRepository {
    private UserDao userDao;
    private ApiService apiService;
    public UserRepository(AppDatabase appDatabase){
        this.userDao = appDatabase.userDao();
        this.apiService = RetrofitClient.getInstance().create(ApiService.class);
    }

    public Call<List<User>> getUsers(){
        return apiService.getUsers();
    }

    public Call<User> getUserDetail(int userId){
        return apiService.getUserDetail(userId);
    }

    public void insertUsers(List<User> users){
                userDao.insertAll(users);
    }

    public LiveData<List<User>> getUsersFromDb(){
        return userDao.getUsers();
    }
}
