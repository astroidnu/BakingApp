package com.scoproject.bakingapp.ui.activity.step;

import com.scoproject.bakingapp.di.scope.ActivityScope;
import com.scoproject.bakingapp.ui.activity.detailstep.DetailStepActivity;
import com.scoproject.bakingapp.ui.activity.detailstep.DetailStepPresenter;
import com.scoproject.bakingapp.ui.fragment.detailstep.DetailStepFragment;
import com.scoproject.bakingapp.ui.fragment.detailstep.DetailStepFragmentPresenter;
import com.scoproject.bakingapp.ui.fragment.step.StepFragmentPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ibnumuzzakkir on 8/19/17.
 * Android Engineer
 * SCO Project
 */

@Module
public class StepModule {
    private StepActivity stepActivity;
    private DetailStepActivity detailStepActivity;


    public StepModule(StepActivity stepActivity) {
        this.stepActivity = stepActivity;
    }

    public StepModule(DetailStepActivity detailStepActivity) {
        this.detailStepActivity = detailStepActivity;
    }

    @Provides
    @ActivityScope
    StepActivity provideStepActivity() {
        return stepActivity;
    }


    @Provides
    @ActivityScope
    DetailStepActivity provideDetailStepActivity() {
        return detailStepActivity;
    }


    @Provides
    @ActivityScope
    StepPresenter provideStepPresenter() {
        return new StepPresenter();
    }

    @Provides
    @ActivityScope
    StepFragmentPresenter provideStepFragmentPresenter() {
        return new StepFragmentPresenter();
    }

    @Provides
    @ActivityScope
    DetailStepFragmentPresenter provideDetailStepFragmentPresenter() {
        return new DetailStepFragmentPresenter();
    }

}
