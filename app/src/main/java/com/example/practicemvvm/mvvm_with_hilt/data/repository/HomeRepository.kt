package com.example.practicemvvm.mvvm_with_hilt.data.repository

import android.net.Network
import com.example.practicemvvm.mvvm_with_hilt.data.model.response.HomeResponse
import com.example.practicemvvm.mvvm_without_dagger.util.NetworkResult

interface HomeRepository {
    suspend fun callHomeApi() : NetworkResult<HomeResponse>
}