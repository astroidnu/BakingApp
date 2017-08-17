package com.scoproject.bakingapp.ui.fragment.step;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scoproject.bakingapp.BakingApp;
import com.scoproject.bakingapp.R;
import com.scoproject.bakingapp.ui.activity.home.HomeActivity;
import com.scoproject.bakingapp.ui.activity.home.HomeModule;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by ibnumuzzakkir on 8/17/17.
 * Android Engineer
 * SCO Project
 */

public class StepFragment extends Fragment implements StepContract.View {
    @Inject
    StepPresenter mStepPresenter;
    private StepContract.UserActionListener mActionListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_master_list, container, false);
        setupFragmentComponent();
        mActionListener = mStepPresenter;
        mStepPresenter.setView(this);
        ButterKnife.bind(this, view);
        return view;
    }

    private void setupFragmentComponent() {
        BakingApp.get()
                .getAppComponent()
                .plus(new HomeModule((HomeActivity) getActivity()))
                .inject(this);
    }

}
