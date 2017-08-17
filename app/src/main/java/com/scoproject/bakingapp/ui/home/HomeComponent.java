package com.scoproject.bakingapp.ui.home;

import com.scoproject.bakingapp.di.scope.ActivityScope;

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
}

