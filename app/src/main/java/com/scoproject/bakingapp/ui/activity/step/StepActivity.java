package com.scoproject.bakingapp.ui.activity.step;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.scoproject.bakingapp.BakingApp;
import com.scoproject.bakingapp.R;
import com.scoproject.bakingapp.data.Receipe;
import com.scoproject.bakingapp.ui.fragment.detailstep.DetailStepFragment;
import com.scoproject.bakingapp.ui.fragment.step.StepFragment;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by ibnumuzzakkir on 8/19/17.
 * Android Engineer
 * SCO Project
 */

public class StepActivity extends AppCompatActivity implements StepContract.View {
    @Inject
    StepPresenter mStepPresenter;

    private StepFragment mStepFragment;
    private DetailStepFragment mDetailStepFragment;
    private HashMap<String, Fragment> fragments;
    private Fragment currentFragment;
    private FragmentManager mFragmentManager;
    private StepContract.UserActionListener mActionListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step);
        ButterKnife.bind(this);
        setupActivityComponent();
        mActionListener = mStepPresenter;
        mStepPresenter.setView(this);
        setupFragment();
        Bundle bundle = getIntent().getExtras();
        getSupportActionBar().setHomeButtonEnabled(true);
        if(bundle != null){
            Receipe receipe = bundle.getParcelable("receipeData");
            loadFragment("stepFragment", bundle,receipe.getName());
        }
    }

    private void setupActivityComponent() {
        BakingApp.get()
                .getAppComponent()
                .plus(new StepModule(this))
                .inject(this);
    }


    public void setupFragment() {
        mStepFragment = new StepFragment();
        mDetailStepFragment = new DetailStepFragment();
        fragments = new HashMap<>();
        fragments.put("stepFragment", mStepFragment);
        fragments.put("detailStepFragment", mDetailStepFragment);
    }

    public void loadFragment(String fragmentId, Bundle bundle, String title) {
        mFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        if(!fragmentId.equals("receipeFragment")){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);}
        currentFragment = fragments.get(fragmentId);
        if(bundle != null){
            currentFragment.setArguments(bundle);}
        getSupportActionBar().setTitle(title);
        transaction.replace(R.id.frame_step, currentFragment, fragmentId);
        transaction.commit();
    }

    public void loadDetailStepFragment(String fragmentId, Bundle bundle, String title) {
        mFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        if(!fragmentId.equals("receipeFragment")){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);}
        currentFragment = fragments.get(fragmentId);
        if(bundle != null){
            currentFragment.setArguments(bundle);}
        getSupportActionBar().setTitle(title);
        transaction.addToBackStack(null);
        transaction.detach(currentFragment);
        transaction.attach(currentFragment);
        transaction.replace(R.id.frame_detail, currentFragment, fragmentId);
        transaction.commit();
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        this.finish();
    }


}
