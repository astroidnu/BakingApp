package com.scoproject.bakingapp.api;

import com.scoproject.bakingapp.data.Receipe;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;

/**
 * Created by ibnumuzzakkir on 8/17/17.
 * Android Engineer
 * SCO Project
 */

public interface NetworkService {
    @GET("android-baking-app-json")
    Flowable<ApiResponse<List<Receipe>>> getBakingData();
}
