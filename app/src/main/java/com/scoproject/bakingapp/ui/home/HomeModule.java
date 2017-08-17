package com.scoproject.bakingapp.ui.home;

import com.scoproject.bakingapp.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ibnumuzzakkir on 8/17/17.
 * Android Engineer
 * SCO Project
 */

@Module
public class HomeModule {
    private HomeActivity homeActivity;
    public HomeModule(HomeActivity homeActivity) {
        this.homeActivity = homeActivity;
    }

    @Provides
    @ActivityScope
    HomeActivity provideHomeActivity() {
        return homeActivity;
    }

}
