package com.example.practicemvvm.mvvm_without_dagger.ui.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practicemvvm.mvvm_without_dagger.data.model.response.LoginResponse
import com.example.practicemvvm.mvvm_without_dagger.data.repository.LoginRepositoryImpl
import com.example.practicemvvm.mvvm_without_dagger.util.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel(var loginRepository: LoginRepositoryImpl): ViewModel() {
    private val _loginLiveData  = MutableLiveData<NetworkResult<LoginResponse>>()
    var loginLiveData  : LiveData<NetworkResult<LoginResponse>> = _loginLiveData

    fun callLoginApi(){
        _loginLiveData.value = NetworkResult.Loading()
        var loginResponse : NetworkResult<LoginResponse>
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                loginResponse = loginRepository.callLogin()
            }
            withContext(Dispatchers.Main){
                _loginLiveData.value = loginResponse
            }
        }
        //val loginResponse = LoginResponse(null, null,  null)
        //_loginLiveData.value = NetworkResult.Success(loginResponse)
        //_loginLiveData.value = NetworkResult.Error("print your message here")
    }
}