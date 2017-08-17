package com.scoproject.bakingapp.api;

import com.scoproject.bakingapp.data.Baking;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;

/**
 * Created by ibnumuzzakkir on 8/17/17.
 * Android Engineer
 * SCO Project
 */

public interface NetworkService {
    @GET("topher/2017/May/59121517_baking/baking.json")
    Flowable<ApiResponse<List<Baking>>> getBakingData();
}
