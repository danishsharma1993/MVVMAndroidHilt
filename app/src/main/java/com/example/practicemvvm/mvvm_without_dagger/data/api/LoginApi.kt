package com.example.practicemvvm.mvvm_without_dagger.data.api

import com.example.practicemvvm.mvvm_without_dagger.data.model.response.LoginResponse
import com.example.practicemvvm.mvvm_without_dagger.util.Constants
import retrofit2.http.GET

interface LoginApi {
    @GET(Constants.LOGIN)
    suspend fun callLogin(): LoginResponse
}