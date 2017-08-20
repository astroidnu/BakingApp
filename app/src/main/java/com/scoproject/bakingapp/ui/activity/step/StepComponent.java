package com.scoproject.bakingapp.ui.activity.step;

import com.scoproject.bakingapp.di.scope.ActivityScope;
import com.scoproject.bakingapp.ui.activity.detailstep.DetailStepActivity;
import com.scoproject.bakingapp.ui.activity.home.HomeModule;
import com.scoproject.bakingapp.ui.fragment.detailstep.DetailStepFragment;
import com.scoproject.bakingapp.ui.fragment.step.StepFragment;

import dagger.Subcomponent;

/**
 * Created by ibnumuzzakkir on 8/19/17.
 * Android Engineer
 * SCO Project
 */

@ActivityScope
@Subcomponent(
        modules = StepModule.class
)
public interface StepComponent {
    StepActivity inject(StepActivity mainActivity);
    StepFragment inject(StepFragment stepFragment);
    DetailStepFragment inject(DetailStepFragment detailStepFragment);
    void inject(DetailStepActivity detailStepActivity);
}
