package com.scoproject.bakingapp.ui.activity.home;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.scoproject.bakingapp.BakingApp;
import com.scoproject.bakingapp.R;
import com.scoproject.bakingapp.ui.fragment.receipe.ReceipeFragment;

import java.util.HashMap;

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
    private ReceipeFragment mReceipeFragment;
    private final Handler mDrawerHandler = new Handler();
    private HashMap<String, Fragment> fragments;
    private Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        setupActivityComponent();
        mActionListener = mHomePresenter;
        mHomePresenter.setView(this);
        setupFragment();
        loadFragment("receipeFragment");
        Timber.tag(getClass().getName());
    }

    private void setupActivityComponent() {
        BakingApp.get()
                .getAppComponent()
                .plus(new HomeModule(this))
                .inject(this);
    }

    @Override
    public void loadFragment(String fragmentId) {
        mDrawerHandler.removeCallbacksAndMessages(null);
        mDrawerHandler.postDelayed(() -> {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            currentFragment = fragments.get(fragmentId);
            transaction.replace(R.id.frame_home, currentFragment, fragmentId);
            transaction.addToBackStack(null);
            transaction.commit();
        },5);
    }

    @Override
    public void setupFragment() {
        mReceipeFragment = new ReceipeFragment();
        fragments = new HashMap<>();
        fragments.put("receipeFragment", mReceipeFragment);
    }
}
