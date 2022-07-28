package com.example.practicemvvm.mvvm_with_hilt.di

import com.example.practicemvvm.mvvm_with_hilt.data.api.HomeApi
import com.example.practicemvvm.mvvm_with_hilt.data.repository.HomeRepository
import com.example.practicemvvm.mvvm_with_hilt.data.repository.HomeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object LoginModule {

    @Provides
    fun provideHomeApi(retrofit: Retrofit): HomeApi =
        retrofit.create(HomeApi::class.java)

    @Provides
    fun provideHomeRepository(homeRepository: HomeRepositoryImpl): HomeRepository {
        return homeRepository
    }
}