package com.scoproject.bakingapp.ui.fragment.receipe;

import android.util.Log;

import com.scoproject.bakingapp.data.Receipe;
import com.scoproject.bakingapp.repository.MainRepository;
import com.scoproject.bakingapp.utils.CustomResourceSubscriber;
import com.scoproject.bakingapp.vo.Resource;

import java.util.List;

import io.reactivex.annotations.NonNull;

/**
 * Created by ibnumuzzakkir on 8/17/17.
 * Android Engineer
 * SCO Project
 */

public class ReceipePresenter implements ReceipeContract.UserActionListener {
    private MainRepository mMainRepository;

    private ReceipeContract.View mView;

    public ReceipePresenter(MainRepository mainRepository) {
        mMainRepository = mainRepository;
    }

    public void setView(ReceipeContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void getBakingData() {
        mMainRepository.getBakingData()
                .subscribe(new CustomResourceSubscriber<Resource<List<Receipe>>>() {
                    @Override
                    protected void onNextAndCompleted(@NonNull Resource<List<Receipe>> body) {
                       mView.setReceipeAdapter(body.data);
                    }

                    @Override
                    protected void onError(String errorMessage) {
                        Log.e(getClass().getName(), errorMessage);
                    }
                });
    }
}
