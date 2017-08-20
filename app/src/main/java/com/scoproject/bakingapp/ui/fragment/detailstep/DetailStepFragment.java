package com.scoproject.bakingapp.ui.fragment.detailstep;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scoproject.bakingapp.BakingApp;
import com.scoproject.bakingapp.R;
import com.scoproject.bakingapp.ui.activity.detailstep.DetailStepActivity;
import com.scoproject.bakingapp.ui.activity.home.HomeActivity;
import com.scoproject.bakingapp.ui.activity.home.HomeModule;
import com.scoproject.bakingapp.ui.activity.step.StepActivity;
import com.scoproject.bakingapp.ui.activity.step.StepModule;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by ibnumuzzakkir on 8/19/17.
 * Android Engineer
 * SCO Project
 */

public class DetailStepFragment extends Fragment implements DetailStepFragmentContract.View {
    @Inject
    DetailStepFragmentPresenter mDetailStepFragmentPresenter;

    private DetailStepFragmentContract.UserActionListener mActionListener;
    private int source = 0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail_step, container, false);
        Bundle bundle = getArguments();
        if(bundle != null){
            source =  bundle.getInt("source");
        }
        if(source == 0){
            BakingApp.get()
                    .getAppComponent()
                    .plus(new StepModule((StepActivity) getActivity()))
                    .inject(this);
        }else{
            BakingApp.get()
                    .getAppComponent()
                    .plus(new StepModule((DetailStepActivity) getActivity()))
                    .inject(this);
        }
        mActionListener = mDetailStepFragmentPresenter;
        mDetailStepFragmentPresenter.setView(this);
        ButterKnife.bind(this, view);
        return view;
    }


}
