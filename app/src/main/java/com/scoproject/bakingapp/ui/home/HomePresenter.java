package com.scoproject.bakingapp.ui.home;

import com.scoproject.bakingapp.data.Baking;
import com.scoproject.bakingapp.repository.MainRepository;
import com.scoproject.bakingapp.utils.CustomResourceSubscriber;
import com.scoproject.bakingapp.vo.Resource;

import java.util.List;

import io.reactivex.annotations.NonNull;
import timber.log.Timber;

/**
 * Created by ibnumuzzakkir on 8/17/17.
 * Android Engineer
 * SCO Project
 */

public class HomePresenter implements HomeContract.UserActionListener {
    private MainRepository mMainRepository;
    private HomeContract.View mView;
    public HomePresenter(MainRepository mainRepository) {
        mMainRepository = mainRepository;
    }


    @Override
    public void getBakingData() {
        mMainRepository.getBakingData()
                .subscribe(new CustomResourceSubscriber<Resource<List<Baking>>>() {
                    @Override
                    protected void onNextAndCompleted(@NonNull Resource<List<Baking>> body) {
                        Timber.d(body.data.toString());
                    }

                    @Override
                    protected void onError(String errorMessage) {
                        Timber.e(errorMessage);
                    }
                });
    }

    public void setView(HomeContract.View view) {
        mView = view;
    }
}
