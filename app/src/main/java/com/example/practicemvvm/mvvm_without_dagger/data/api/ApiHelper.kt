package com.example.practicemvvm.mvvm_without_dagger.data.api

import com.example.practicemvvm.mvvm_without_dagger.data.model.response.LoginResponse

//We can directly use LoginApi to call the API in Repository impl
class ApiHelper(private val loginApi: LoginApi) {
    suspend fun callLogin(): LoginResponse {
       return loginApi.callLogin()
    }
}