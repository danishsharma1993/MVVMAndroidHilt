package com.example.practicemvvm.mvvm_with_hilt.data.api

import com.example.practicemvvm.mvvm_with_hilt.data.model.response.HomeResponse
import com.example.practicemvvm.mvvm_with_hilt.util.Constants
import retrofit2.http.GET

interface HomeApi {
    @GET(Constants.HOME)
    suspend fun callHome(): HomeResponse
}