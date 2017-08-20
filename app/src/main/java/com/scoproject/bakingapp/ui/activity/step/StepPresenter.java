package com.scoproject.bakingapp.ui.activity.step;

/**
 * Created by ibnumuzzakkir on 8/19/17.
 * Android Engineer
 * SCO Project
 */

public class StepPresenter implements StepContract.UserActionListener {
    private StepContract.View mView;


    public void setView(StepContract.View view) {
        mView = view;
    }
}
