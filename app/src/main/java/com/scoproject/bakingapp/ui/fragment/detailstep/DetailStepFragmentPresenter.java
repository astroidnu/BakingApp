package com.scoproject.bakingapp.ui.fragment.detailstep;

/**
 * Created by ibnumuzzakkir on 8/19/17.
 * Android Engineer
 * SCO Project
 */

public class DetailStepFragmentPresenter implements DetailStepFragmentContract.UserActionListener {
    private DetailStepFragmentContract.View mView;

    public DetailStepFragmentPresenter() {

    }

    public void setView(DetailStepFragmentContract.View mView) {
        this.mView = mView;
    }

}
