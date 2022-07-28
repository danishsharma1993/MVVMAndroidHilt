package com.example.practicemvvm.mvvm_without_dagger.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.practicemvvm.mvvm_without_dagger.data.repository.LoginRepositoryImpl
import com.example.practicemvvm.mvvm_without_dagger.ui.view_model.LoginViewModel

class SomeViewModelFactory(private val loginRepository: LoginRepositoryImpl): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LoginViewModel(loginRepository) as T
    }
}