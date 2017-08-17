package com.scoproject.bakingapp.ui.home;

import android.content.Context;

import com.scoproject.bakingapp.api.NetworkService;
import com.scoproject.bakingapp.di.scope.ActivityScope;
import com.scoproject.bakingapp.repository.MainRepository;

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

    @Provides
    @ActivityScope
    MainRepository provideMainRepository(NetworkService networkService) {
        return new MainRepository(networkService);
    }

    @Provides
    @ActivityScope
    HomePresenter provideMainPresenter(MainRepository mainRepository,Context context) {
        return new HomePresenter(mainRepository);
    }
}
