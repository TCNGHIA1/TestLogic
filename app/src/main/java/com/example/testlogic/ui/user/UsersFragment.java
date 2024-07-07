package com.example.testlogic.ui.user;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavHost;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.testlogic.MainActivity;
import com.example.testlogic.R;
import com.example.testlogic.adapters.UserAdapter;
import com.example.testlogic.api.Resource;
import com.example.testlogic.models.User;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class UsersFragment extends Fragment {

    private UserViewModel viewModel;
    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private SwipeRefreshLayout swiper_layout;

    private static final String TAG = "UsersFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_users, container, false);
        recyclerView = view.findViewById(R.id.rv_users);
        swiper_layout = view.findViewById(R.id.swiper_layout);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setupViewModel();
        setupRecyclerView();
        observeUsers();
        handleRefreshData();

        viewModel.fetchUsers();  // Fetch data initially
    }

    /**
     * Thiết lập SwipeRefreshLayout để xử lý hành động vuốt xuống làm mới danh sách.
     */
    private void handleRefreshData() {
        swiper_layout.setOnRefreshListener(() -> {
            viewModel.fetchUsers();
            swiper_layout.setRefreshing(false);
        });
    }

    private void setupViewModel() {
        viewModel = ((MainActivity) requireActivity()).getViewModel();
    }

    private void setupRecyclerView() {
        userAdapter = new UserAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(userAdapter);

        userAdapter.setOnClickListener(this::handleClickItemAdapter);
    }

    /**
     * Xử lý click vào item trong danh sách người dùng.
     * Mở chi tiết người dùng tương ứng khi click.
     *
     * @param item Người dùng được click.
     */
    private void handleClickItemAdapter(User item) {
        Bundle bundle = new Bundle();
        bundle.putString("user_login", item.getLogin());

        NavHostFragment.findNavController(this).navigate(R.id.action_nav_users_to_nav_user_detail, bundle);
    }

    private void observeUsers() {
        viewModel.getUsers().observe(getViewLifecycleOwner(), this::handleUsersResource);
    }

    /**
     * Quan sát LiveData chứa danh sách người dùng từ ViewModel.
     * Cập nhật RecyclerView khi danh sách người dùng thay đổi.
     * Hiển thị Snackbar nếu có lỗi xảy ra khi lấy dữ liệu.
     *
     * @param resource Resource chứa danh sách người dùng và trạng thái lấy dữ liệu.
     */
    private void handleUsersResource(Resource<List<User>> resource) {
        switch (resource.getStatus()) {
            case SUCCESS:
                if (resource.getData() != null) {
                    userAdapter.getDiffer().submitList(resource.getData());
                }
                swiper_layout.setRefreshing(false);
                break;
            case ERROR:
                swiper_layout.setRefreshing(false);
                if (resource.getMessage() != null && !resource.getMessage().isEmpty()) {
                    Snackbar.make(getView(), resource.getMessage(), Snackbar.LENGTH_SHORT).show();
                }
                break;
            case LOADING:
                swiper_layout.setRefreshing(true);
                break;
        }
    }
}