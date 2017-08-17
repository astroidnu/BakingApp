package com.scoproject.bakingapp.ui.fragment.step;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.scoproject.bakingapp.BakingApp;
import com.scoproject.bakingapp.R;
import com.scoproject.bakingapp.adapter.StepAdapter;
import com.scoproject.bakingapp.data.Step;
import com.scoproject.bakingapp.ui.activity.home.HomeActivity;
import com.scoproject.bakingapp.ui.activity.home.HomeModule;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ibnumuzzakkir on 8/17/17.
 * Android Engineer
 * SCO Project
 */

public class StepFragment extends Fragment implements StepContract.View {
    @Inject
    StepPresenter mStepPresenter;
    @BindView(R.id.rv_master)
    RecyclerView mRvStep;

    private StepContract.UserActionListener mActionListener;
    private StepAdapter mStepAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_master_list, container, false);
        setupFragmentComponent();
        ButterKnife.bind(this, view);
        mActionListener = mStepPresenter;
        mStepPresenter.setView(this);
        Bundle bundle = getArguments();
        if(bundle != null){
            List<Step> data = bundle.getParcelableArrayList("step_data");
            setStepAdapter(data);
        }
        return view;
    }

    private void setupFragmentComponent() {
        BakingApp.get()
                .getAppComponent()
                .plus(new HomeModule((HomeActivity) getActivity()))
                .inject(this);
    }

    @Override
    public void setStepAdapter(List<Step> stepList) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mStepAdapter = new StepAdapter(stepList);
        mRvStep.setLayoutManager(linearLayoutManager);
        mRvStep.setAdapter(mStepAdapter);
    }
}
