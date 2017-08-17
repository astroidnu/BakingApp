package com.scoproject.bakingapp.di.component;

import com.scoproject.bakingapp.di.module.AppModule;
import com.scoproject.bakingapp.di.module.NetworkModule;
import com.scoproject.bakingapp.ui.activity.home.HomeComponent;
import com.scoproject.bakingapp.ui.activity.home.HomeModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ibnumuzzakkir on 8/17/17.
 * Android Engineer
 * SCO Project
 */

@Singleton
@Component(
        modules = {
                AppModule.class,
                NetworkModule.class
        }
)
public interface AppComponent {
    HomeComponent plus(HomeModule homeModule);
}
