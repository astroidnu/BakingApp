package com.scoproject.bakingapp.ui.fragment.step;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scoproject.bakingapp.BakingApp;
import com.scoproject.bakingapp.R;
import com.scoproject.bakingapp.adapter.StepAdapter;
import com.scoproject.bakingapp.data.Ingredient;
import com.scoproject.bakingapp.data.Receipe;
import com.scoproject.bakingapp.data.Step;
import com.scoproject.bakingapp.ui.activity.detailstep.DetailStepActivity;
import com.scoproject.bakingapp.ui.activity.step.StepActivity;
import com.scoproject.bakingapp.ui.activity.step.StepModule;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ibnumuzzakkir on 8/17/17.
 * Android Engineer
 * SCO Project
 */

public class StepFragment extends Fragment implements StepFragmentContract.View, StepAdapter.OnStepClicked {
    @Inject
    StepFragmentPresenter mStepFragmentPresenter;
    @BindView(R.id.rv_master)
    RecyclerView mRvStep;

    private StepFragmentContract.UserActionListener mActionListener;
    private StepAdapter mStepAdapter;
    private Boolean mTwoPane = false;
    private Receipe mReceipe = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_step, container, false);
        setupFragmentComponent();
        ButterKnife.bind(this, view);
        mActionListener = mStepFragmentPresenter;
        mStepFragmentPresenter.setView(this);
        Bundle bundle = getArguments();
        if(bundle != null){
            mReceipe = bundle.getParcelable("receipeData");
            List<Step> stepList = mReceipe.getSteps();
            List<Ingredient> ingredientList = mReceipe.getIngredients();
            setStepAdapter(stepList, ingredientList);
        }
        if (view.findViewById(R.id.frame_detail) != null) {
            mTwoPane = true;
        }else{
            mTwoPane = false;
        }

        return view;
    }

    private void setupFragmentComponent() {
        BakingApp.get()
                .getAppComponent()
                .plus(new StepModule((StepActivity) getActivity()))
                .inject(this);
    }

    @Override
    public void setStepAdapter(List<Step> stepList, List<Ingredient> ingredientList) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mStepAdapter = new StepAdapter(stepList, ingredientList, this);
        mRvStep.setLayoutManager(linearLayoutManager);
        mRvStep.setAdapter(mStepAdapter);
    }

    @Override
    public void onStepClicked(Step step) {
        if(mTwoPane){
             Bundle bundle = new Bundle();
            bundle.putParcelable("data", step);
            ((StepActivity)getActivity()).loadDetailStepFragment("detailStepFragment",bundle,step.getShortDescription());
        }else{
            Intent intent = new Intent(getContext(), DetailStepActivity.class);
            getContext().startActivity(intent);
        }

    }
}
