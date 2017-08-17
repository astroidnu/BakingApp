package com.scoproject.bakingapp.ui.activity.home;

import com.scoproject.bakingapp.api.NetworkService;
import com.scoproject.bakingapp.di.scope.ActivityScope;
import com.scoproject.bakingapp.repository.MainRepository;
import com.scoproject.bakingapp.ui.fragment.receipe.ReceipePresenter;
import com.scoproject.bakingapp.ui.fragment.step.StepPresenter;

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
    HomePresenter provideMainPresenter(MainRepository mainRepository) {
        return new HomePresenter(mainRepository);
    }

    @Provides
    @ActivityScope
    ReceipePresenter provideReceipePresenter(MainRepository mainRepository) {
        return new ReceipePresenter(mainRepository);
    }

    @Provides
    @ActivityScope
    StepPresenter provideStepPresenter() {
        return new StepPresenter();
    }
}
