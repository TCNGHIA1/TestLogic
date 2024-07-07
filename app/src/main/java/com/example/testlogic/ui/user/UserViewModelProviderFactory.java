package com.example.testlogic.ui.user;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.testlogic.api.repository.UserRepository;

public class UserViewModelProviderFactory implements ViewModelProvider.Factory {
    private UserRepository repository;
    private Application app;
    public UserViewModelProviderFactory(Application application, UserRepository repository){
        this.repository = repository;
        this.app = application;
    }
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new UserViewModel(app,repository);
    }
}
