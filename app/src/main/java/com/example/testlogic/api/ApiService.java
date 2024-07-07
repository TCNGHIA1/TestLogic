package com.example.testlogic.api;

import com.example.testlogic.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    @GET("users")
    Call<List<User>> getUsers();

    @GET("users/{id}")
    Call<User> getUserDetail(@Path("id") int userId);
}
