package com.scoproject.bakingapp.api;


import com.scoproject.bakingapp.vo.Resource;

/**
 * Created by ibnumuzzakkir on 15/06/2017.
 * Android Developer
 * Garena Indonesia
 */


public class ApiWrapper {
    public static <T> Resource<T> fetchApi(ApiResponse<T> response) {
        if (response.isSuccessful()) {
            if(response.body != null){
                return Resource.success(response.body);
            }
        } else {
            return Resource.error(response.errorMessage, null);
        }
        return Resource.error("Somethings Wrong", null);
    }
}
