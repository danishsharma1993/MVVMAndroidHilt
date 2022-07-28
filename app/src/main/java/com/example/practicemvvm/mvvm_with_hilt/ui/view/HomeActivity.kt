package com.example.practicemvvm.mvvm_with_hilt.ui.view

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.practicemvvm.R
import com.example.practicemvvm.databinding.ActivityHomeBinding
import com.example.practicemvvm.mvvm_with_hilt.ui.view_model.HomeViewModel
import com.example.practicemvvm.mvvm_with_hilt.util.SharedPreferenceClient
import com.example.practicemvvm.mvvm_without_dagger.util.NetworkResult
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    private val homeViewModel by viewModels<HomeViewModel>()

    @Inject
    lateinit var sharedPreferenceClient: SharedPreferenceClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        clickListeners()
        observerViewModels()
    }

    private fun clickListeners() {
        binding.btnCallApi.setOnClickListener {
            Log.d("--observer--", "Button Clicked")
            homeViewModel.callHomeApi()
        }
    }

    private fun observerViewModels() {
        homeViewModel.homeLiveData.observe(this) { response ->
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
                }
            }
        }
    }

    private fun sharedPreferences(){
        sharedPreferenceClient.setEmail("danish.sharma1993@gmail.com")
        sharedPreferenceClient.setIsPaidUser(true)
        sharedPreferenceClient.setAge(29)

        Log.d(
            "--observer--value--",
            "email = " + sharedPreferenceClient.getEmail()
                    + " age = " + sharedPreferenceClient.getAge()
                    + " isPaidUser " + sharedPreferenceClient.getIsPaidUser()
        )
    }
}