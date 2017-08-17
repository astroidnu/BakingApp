package com.scoproject.bakingapp.ui.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;

import com.scoproject.bakingapp.BakingApp;
import com.scoproject.bakingapp.R;

import butterknife.ButterKnife;

/**
 * Created by ibnumuzzakkir on 8/17/17.
 * Android Engineer
 * SCO Project
 */

public class HomeActivity extends AppCompatActivity implements HomeContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        setupActivityComponent();
    }

    private void setupActivityComponent() {
        BakingApp.get()
                .getAppComponent()
                .plus(new HomeModule(this))
                .inject(this);
    }

}
