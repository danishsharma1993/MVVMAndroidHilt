package com.example.practicemvvm.mvvm_without_dagger.data.repository

import com.example.practicemvvm.mvvm_without_dagger.data.api.LoginApi
import com.example.practicemvvm.mvvm_without_dagger.data.model.response.LoginResponse
import com.example.practicemvvm.mvvm_without_dagger.ui.base.BaseRepository
import com.example.practicemvvm.mvvm_without_dagger.util.NetworkResult

class LoginRepositoryImpl(private val loginApi: LoginApi): LoginRepository, BaseRepository() {
   override suspend fun callLogin(): NetworkResult<LoginResponse>{
        return safeApiCall {
            loginApi.callLogin()
        }
    }
}