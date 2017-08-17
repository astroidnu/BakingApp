package com.scoproject.bakingapp.ui.activity.home;


import com.scoproject.bakingapp.repository.MainRepository;


/**
 * Created by ibnumuzzakkir on 8/17/17.
 * Android Engineer
 * SCO Project
 */

public class HomePresenter implements HomeContract.UserActionListener {
    private MainRepository mMainRepository;
    private HomeContract.View mView;

    public HomePresenter(MainRepository mainRepository) {
        mMainRepository = mainRepository;
    }

    public void setView(HomeContract.View view) {
        mView = view;
    }

    @Override
    public void getBakingData() {
    }
}
