package com.scoproject.bakingapp.ui.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;

import com.scoproject.bakingapp.BakingApp;
import com.scoproject.bakingapp.R;

import javax.inject.Inject;

import butterknife.ButterKnife;
import timber.log.Timber;

/**
 * Created by ibnumuzzakkir on 8/17/17.
 * Android Engineer
 * SCO Project
 */

public class HomeActivity extends AppCompatActivity implements HomeContract.View {
    @Inject
    HomePresenter mHomePresenter;
    private HomeContract.UserActionListener mActionListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        setupActivityComponent();
        mActionListener = mHomePresenter;
        mHomePresenter.setView(this);
        mActionListener.getBakingData();
        Timber.tag(getClass().getName());
    }

    private void setupActivityComponent() {
        BakingApp.get()
                .getAppComponent()
                .plus(new HomeModule(this))
                .inject(this);
    }

}
