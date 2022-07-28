package com.example.practicemvvm.mvvm_without_dagger.data.repository

import com.example.practicemvvm.mvvm_without_dagger.data.model.response.LoginResponse
import com.example.practicemvvm.mvvm_without_dagger.util.NetworkResult

interface LoginRepository {
    suspend fun callLogin(): NetworkResult<LoginResponse>
}