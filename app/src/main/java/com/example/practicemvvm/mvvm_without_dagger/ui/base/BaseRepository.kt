package com.example.practicemvvm.mvvm_without_dagger.ui.base

import com.example.practicemvvm.mvvm_without_dagger.util.NetworkResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class BaseRepository {
    suspend fun <T> safeApiCall(
        dispatcher: CoroutineDispatcher = Dispatchers.IO,
        apiCall: suspend () -> T
    ): NetworkResult<T> {
        return withContext(dispatcher) {
            try {
                val result = apiCall.invoke()
                NetworkResult.Success(result)
            } catch (throwable: Exception) {
                // show toast message or alert which error message
                // call same api again apiCall.invoke() or safeApiCall()
                NetworkResult.Error(throwable)
            }
        }
    }
}