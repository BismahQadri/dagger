package com.example.dagger.di.main

import com.example.dagger.network.main.MainApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class MainModule {

    companion object{
        @Provides
        fun provideMainApi(retrofit: Retrofit) : MainApi{
            return retrofit.create(MainApi::class.java)
        }
    }
}