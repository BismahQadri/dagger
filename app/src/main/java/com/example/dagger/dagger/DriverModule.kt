package com.example.dagger.dagger

import com.example.dagger.car.Driver
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
 class DriverModule {

    @Provides
    @Singleton
    fun provideDriver() : Driver {
        return Driver()
    }
}