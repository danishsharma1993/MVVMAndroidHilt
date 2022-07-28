package com.example.practicemvvm.mvvm_without_dagger.util

sealed class NetworkResult<T>(
    val data: T? = null,
    val message: String? = null,
    val throwable: Throwable?
) {

    class Success<T>(data: T) : NetworkResult<T>(data, null, null)

    class Error<T>(message: Throwable?=null, data: T?=null) : NetworkResult<T>(data, null, message)

    class Loading<T> : NetworkResult<T>(null, null, null)

}