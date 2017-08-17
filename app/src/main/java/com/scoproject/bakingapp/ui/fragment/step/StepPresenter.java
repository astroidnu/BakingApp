package com.scoproject.bakingapp.ui.fragment.step;

/**
 * Created by ibnumuzzakkir on 8/17/17.
 * Android Engineer
 * SCO Project
 */

public class StepPresenter implements StepContract.UserActionListener {
    private StepContract.View mView;

    public void setView(StepContract.View view) {
        mView = view;
    }
}
