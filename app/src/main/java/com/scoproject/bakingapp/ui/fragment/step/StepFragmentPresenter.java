package com.scoproject.bakingapp.ui.fragment.step;

/**
 * Created by ibnumuzzakkir on 8/17/17.
 * Android Engineer
 * SCO Project
 */

public class StepFragmentPresenter implements StepFragmentContract.UserActionListener {
    private StepFragmentContract.View mView;

    public void setView(StepFragmentContract.View view) {
        mView = view;
    }
}
