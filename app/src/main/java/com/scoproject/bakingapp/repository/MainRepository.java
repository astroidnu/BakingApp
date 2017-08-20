package com.scoproject.bakingapp.repository;


import com.scoproject.bakingapp.api.ApiWrapper;
import com.scoproject.bakingapp.api.NetworkService;
import com.scoproject.bakingapp.data.Receipe;
import com.scoproject.bakingapp.vo.Resource;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ibnumuzzakkir on 8/17/17.
 * Android Engineer
 * SCO Project
 */

public class MainRepository extends BaseRepository{
    public MainRepository(NetworkService networkService) {
        super(networkService);
    }

    /**
     * Get Receipe Data
     **/

    public Flowable<Resource<List<Receipe>>> getBakingData() {
        return networkService.getBakingData()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .map(ApiWrapper::fetchApi);
    }
}
