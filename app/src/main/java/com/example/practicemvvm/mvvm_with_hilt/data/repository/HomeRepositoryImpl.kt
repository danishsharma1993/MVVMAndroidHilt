package com.example.practicemvvm.mvvm_with_hilt.data.repository

import com.example.practicemvvm.mvvm_with_hilt.data.api.HomeApi
import com.example.practicemvvm.mvvm_with_hilt.data.model.response.HomeResponse
import com.example.practicemvvm.mvvm_without_dagger.ui.base.BaseRepository
import com.example.practicemvvm.mvvm_without_dagger.util.NetworkResult
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(private val homeApi: HomeApi) : HomeRepository,
    BaseRepository() {
    override suspend fun callHomeApi(): NetworkResult<HomeResponse> {
        return safeApiCall {
            homeApi.callHome()
        }
    }
}