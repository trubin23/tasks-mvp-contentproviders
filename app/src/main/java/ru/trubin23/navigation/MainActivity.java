package ru.trubin23.navigation;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity implements
        Fragment1.OnFragment1Listener,
        Fragment2.OnFragment2Listener,
        Fragment3.OnFragment3Listener {

    NavController mNavController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavController = Navigation.findNavController(this, R.id.nav_host_fragment);

        BottomNavigationView bottomNavView = findViewById(R.id.bottom_nav_view);
        NavigationUI.setupWithNavController(bottomNavView, mNavController);
    }

    @Override
    public void onFragment1NextClick() {
        mNavController.navigate(R.id.action_fragment1_to_fragment2);
    }

    @Override
    public void onFragment1BackClick() {

    }

    @Override
    public void onFragment2NextClick() {
        Fragment2Directions.ActionFragment2ToFragment3 action =
                Fragment2Directions.actionFragment2ToFragment3();

        action.setArg6("replace default");

        mNavController.navigate(action);
    }

    @Override
    public void onFragment2BackClick() {
        mNavController.popBackStack();
    }

    @Override
    public void onFragment3NextClick() {
        mNavController.navigate(R.id.secondActivity);
    }

    @Override
    public void onFragment3BackClick() {
        mNavController.popBackStack();
    }
}
