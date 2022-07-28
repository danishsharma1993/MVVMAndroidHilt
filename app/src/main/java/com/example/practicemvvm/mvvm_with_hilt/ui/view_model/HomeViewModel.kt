package com.example.practicemvvm.mvvm_with_hilt.ui.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practicemvvm.mvvm_with_hilt.data.model.response.HomeResponse
import com.example.practicemvvm.mvvm_with_hilt.data.repository.HomeRepository
import com.example.practicemvvm.mvvm_without_dagger.util.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class HomeViewModel @Inject constructor(
    @Named("IO") private var ioDispatcher: CoroutineDispatcher,
    @Named("MAIN") private var mainDispatcher: CoroutineDispatcher,
    private val homeRepository: HomeRepository
) : ViewModel() {
    private val _homeLiveData = MutableLiveData<NetworkResult<HomeResponse>>()
    var homeLiveData: LiveData<NetworkResult<HomeResponse>> = _homeLiveData

    fun callHomeApi() {
        _homeLiveData.value = NetworkResult.Loading()
        var homeResponse: NetworkResult<HomeResponse>
        viewModelScope.launch {
            withContext(ioDispatcher) {
                homeResponse = homeRepository.callHomeApi()
            }
            withContext(mainDispatcher) {
                _homeLiveData.value = homeResponse
            }
        }
        //val loginResponse = LoginResponse(null, null,  null)
        //_loginLiveData.value = NetworkResult.Success(loginResponse)
        //_loginLiveData.value = NetworkResult.Error("print your message here")
    }
}