package com.example.testlogic.ui.user;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testlogic.MainActivity;
import com.example.testlogic.R;

public class UserDetailFragment extends Fragment {

    private UserViewModel viewModel;

    private String user_login="";

    private static final String TAG = "UserDetailFragment";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user_detail, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setupViewModel();

        if(getArguments()!=null){
            user_login = getArguments().getString("user_login");
        }
    }

    private void setupViewModel() {
        viewModel = ((MainActivity) requireActivity()).getViewModel();
    }

}