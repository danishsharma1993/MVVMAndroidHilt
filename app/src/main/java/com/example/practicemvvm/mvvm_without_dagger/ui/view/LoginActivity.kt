package com.example.practicemvvm.mvvm_without_dagger.ui.view

import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.practicemvvm.R
import com.example.practicemvvm.common.view.BaseActivity
import com.example.practicemvvm.databinding.ActivityLoginBinding
import com.example.practicemvvm.mvvm_without_dagger.data.api.LoginApi
import com.example.practicemvvm.mvvm_without_dagger.data.api.UserListApi
import com.example.practicemvvm.mvvm_without_dagger.data.repository.LoginRepositoryImpl
import com.example.practicemvvm.mvvm_without_dagger.data.retrofit.RetrofitService
import com.example.practicemvvm.mvvm_without_dagger.ui.view_model.LoginViewModel
import com.example.practicemvvm.mvvm_without_dagger.util.NetworkResult
import com.example.practicemvvm.mvvm_without_dagger.util.createFactory
import retrofit2.HttpException

class LoginActivity : BaseActivity() {
    lateinit var binding: ActivityLoginBinding
    private val loginApi = RetrofitService.getInstance().create(LoginApi::class.java)
    private val userListApi = RetrofitService.buildApi(UserListApi::class.java)

    // private val loginViewModel: LoginViewModel by viewModels { SomeViewModelFactory(mainRepository) }
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        // loginViewModel = LoginViewModel by viewModels{SomeViewModelFactory()}
        val factory = LoginViewModel(LoginRepositoryImpl(loginApi)).createFactory()
        loginViewModel = ViewModelProvider(this, factory).get(LoginViewModel::class.java)
        observerViewModels()
        clickListeners()
    }

    private fun clickListeners() {
        binding.btnCallApi.setOnClickListener {
            Log.d("--observer--", "Button Clicked")
            loginViewModel.callLoginApi()
        }
    }

    //https://medium.com/codex/kotlin-sealed-classes-for-better-handling-of-api-response-6aa1fbd23c76
    private fun observerViewModels() {
        loginViewModel.loginLiveData.observe(this) { response ->
            when (response) {
                is NetworkResult.Loading -> {
                    Log.d("--observer--", "--Loading--")
                }
                is NetworkResult.Success -> {
                    Log.d("--observer--", "--Success--")
                    Log.d("--observer--", "--Success--" + response.data?.status)
                }
                is NetworkResult.Error -> {
                    Log.d("--observer--", "--Error--" + response.throwable?.message)
                    handleApiError(response.throwable)
                }
            }
        }
    }

    private fun handleApiError(
        throwable: Throwable? = null,
    ) {
        throwable?.let {
            when (throwable) {
                is HttpException -> {
                    Log.d("--observer--", "--Error--if--" + throwable.response()?.errorBody())
                }
                else -> {
                    Log.d("--observer--", "--Error--else--" + "Internet lost")
                }
            }
        }
    }
}