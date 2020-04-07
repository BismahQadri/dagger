package com.example.dagger.di.auth

import com.example.dagger.network.auth.AuthApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class AuthModule {

    companion object {
        @Provides
        fun provideAuthApi(retrofit: Retrofit) : AuthApi{
            return retrofit.create(AuthApi::class.java)
        }
    }


}