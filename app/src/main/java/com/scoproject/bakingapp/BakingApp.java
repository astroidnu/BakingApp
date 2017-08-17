package com.scoproject.bakingapp;

import android.app.Application;

import com.scoproject.bakingapp.di.component.AppComponent;
import com.scoproject.bakingapp.di.component.DaggerAppComponent;
import com.scoproject.bakingapp.di.module.AppModule;
import com.scoproject.bakingapp.di.module.NetworkModule;

import timber.log.Timber;

/**
 * Created by ibnumuzzakkir on 8/17/17.
 * Android Engineer
 * SCO Project
 */

public class BakingApp extends Application{
    private AppComponent appComponent = createAppComponent();

    private static BakingApp instance;

    public static BakingApp get() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Timber.plant(new Timber.DebugTree());
    }

    protected AppComponent createAppComponent() {
        return appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return  appComponent;
    }
}
