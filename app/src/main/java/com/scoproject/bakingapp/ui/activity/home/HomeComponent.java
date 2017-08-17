package com.scoproject.bakingapp.ui.activity.home;

import com.scoproject.bakingapp.di.scope.ActivityScope;
import com.scoproject.bakingapp.ui.fragment.ReceipeFragment;

import dagger.Subcomponent;

/**
 * Created by ibnumuzzakkir on 8/17/17.
 * Android Engineer
 * SCO Project
 */

@ActivityScope
@Subcomponent(
        modules = HomeModule.class
)
public interface HomeComponent {
    HomeActivity inject(HomeActivity mainActivity);
    ReceipeFragment inject(ReceipeFragment receipeFragment);
}

