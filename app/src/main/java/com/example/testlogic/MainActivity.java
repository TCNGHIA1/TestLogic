package com.example.testlogic;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.testlogic.database.AppDatabase;
import com.example.testlogic.api.repository.UserRepository;
import com.example.testlogic.ui.user.UserViewModel;
import com.example.testlogic.ui.user.UserViewModelProviderFactory;

public class MainActivity extends AppCompatActivity {

    private NavController navController;
    private AppBarConfiguration appBarConfiguration;
    private DrawerLayout drawerLayout;
    private UserViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        UserRepository userRepository = new UserRepository(AppDatabase.getInstance(getApplicationContext()));
        UserViewModelProviderFactory userViewModelProviderFactory = new UserViewModelProviderFactory(getApplication(),userRepository);

        viewModel = new ViewModelProvider(this, userViewModelProviderFactory).get(UserViewModel.class);


        // Handle window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.drawer_layout), (v, windowInsets) -> {
            Insets insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars());

            // Apply insets to drawer layout
            v.setPadding(insets.left, 0, insets.right, insets.bottom);

            // Adjust toolbar for status bar
            ViewGroup.MarginLayoutParams toolbarParams = (ViewGroup.MarginLayoutParams) toolbar.getLayoutParams();
            toolbarParams.topMargin = insets.top;
            toolbar.setLayoutParams(toolbarParams);

            // Adjust content area
            View contentView = findViewById(R.id.nav_host_fragment);
            contentView.setPadding(0, 0, 0, insets.bottom);

            return WindowInsetsCompat.CONSUMED;
        });

        //Use for NavigationView
//        NavigationView navView = findViewById(R.id.nav_view);

        NavHostFragment navHostFragment =
                (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);

        navController = navHostFragment.getNavController();

        drawerLayout = findViewById(R.id.drawer_layout);

        appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_users, R.id.nav_user_detail)
                .setDrawerLayout(drawerLayout)
                .build();

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//        NavigationUI.setupWithNavController(navView, navController);

    }

//    @Override
//    public boolean onSupportNavigateUp() {
//        return NavigationUI.navigateUp(navController, appBarConfiguration)
//                || super.onSupportNavigateUp();
//    }

    public UserViewModel getViewModel() {
        return viewModel;
    }
}