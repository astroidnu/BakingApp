package com.scoproject.bakingapp.ui.activity.detailstep;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.scoproject.bakingapp.BakingApp;
import com.scoproject.bakingapp.R;
import com.scoproject.bakingapp.ui.activity.step.StepModule;
import com.scoproject.bakingapp.ui.fragment.detailstep.DetailStepFragment;

import butterknife.ButterKnife;

/**
 * Created by ibnumuzzakkir on 8/20/17.
 * Android Engineer
 * SCO Project
 */

public class DetailStepActivity extends AppCompatActivity {

    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_step);
        ButterKnife.bind(this);
        setupActivityComponent();
        Bundle bundle = getIntent().getExtras();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Hello");
        loadFragment(new Bundle());
        if(bundle != null){

        }
    }

    private void setupActivityComponent() {
        BakingApp.get()
                .getAppComponent()
                .plus(new StepModule(this))
                .inject(this);
    }

    public void loadFragment(Bundle bundle) {
        DetailStepFragment detailStepFragment = new DetailStepFragment();
        bundle.putInt("source",1);
        detailStepFragment.setArguments(bundle);
        mFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.replace(R.id.frame_detail, detailStepFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


    @Override
    public void onBackPressed(){
        super.onBackPressed();
        this.finish();
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

}
