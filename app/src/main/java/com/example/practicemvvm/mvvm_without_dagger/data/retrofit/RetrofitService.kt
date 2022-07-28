package com.example.practicemvvm.mvvm_without_dagger.data.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitService {

    private const val BASE_URL = "https://api.rss2json.com/v1/"

    fun getInstance(): Retrofit {
        val mHttpLoggingInterceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)

        val mOkHttpClient = OkHttpClient
            .Builder()
            .addInterceptor(mHttpLoggingInterceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create())
            .client(mOkHttpClient)
            .build()
    }

    fun <Api> buildApi(api: Class<Api>): Api {
        return getInstance().create(api)
    }

    // below is the syntax to create the instance of interface to call the api but we'll call this code in activity or fragment
    // val loginApi: LoginApi = getInstance().create(LoginApi::class.java)
}