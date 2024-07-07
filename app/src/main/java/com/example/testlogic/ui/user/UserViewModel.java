package com.example.testlogic.ui.user;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.os.Handler;
import android.util.Log;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.testlogic.api.Resource;
import com.example.testlogic.api.repository.UserRepository;
import com.example.testlogic.models.User;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Lớp này chịu trách nhiệm lấy dữ liệu người dùng và cung cấp cho View.
 *
 */
public class UserViewModel extends AndroidViewModel {
    private UserRepository userRepository;

    /**
     * LiveData chứa danh sách người dùng được bọc trong Resource để biểu thị trạng thái
     * (loading, success, error).
     */
    private MutableLiveData<Resource<List<User>>> users = new MutableLiveData<>();

    public UserViewModel(Application application, UserRepository userRepository) {
        super(application);
        this.userRepository = userRepository;
    }

    /**
     * Lấy danh sách người dùng. Kiểm tra kết nối internet trước.
     * Nếu có kết nối, sẽ lấy dữ liệu từ server và lưu vào database.
     * Ngược lại, sẽ lấy dữ liệu từ database.
     */
    public void fetchUsers() {
        users.postValue(Resource.loading());
        if (hasInternetConnection()) {
            userRepository.getUsers().enqueue(new Callback<List<User>>() {
                @Override
                public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                    if (response.isSuccessful()) {
                        List<User> userList = response.body();
                        insertToDb(userList);
                        users.postValue(Resource.success(userList));
                    } else {
                        users.postValue(Resource.error("Error fetching users: " + response.message()));
                    }
                }
                @Override
                public void onFailure(Call<List<User>> call, Throwable t) {
                        users.postValue(Resource.error("Error fetching users: " + t.getMessage()));
                }
            });
        } else {
            userRepository.getUsersFromDb().observeForever(dbUsers->{
                if (!dbUsers.isEmpty()) {
                    users.postValue(Resource.success(dbUsers));
                } else {
                    users.postValue(Resource.error("No Internet"));
                }
            });

        }
    }


    public LiveData<Resource<List<User>>> getUsers() {
        return users;
    }

    /**
     * Kiểm tra thiết bị có kết nối internet không.
     *
     * @return True nếu có kết nối, False nếu không.
     */
    private boolean hasInternetConnection() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getApplication().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkCapabilities capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
        if (capabilities == null) {
            return false;
        }
        return capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ||
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET);
    }

    private void insertToDb(List<User> user){
        new Thread(()-> userRepository.insertUsers(user)).start();
    }
}
