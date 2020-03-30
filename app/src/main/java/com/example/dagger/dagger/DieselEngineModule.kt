package com.example.dagger.dagger

import com.example.dagger.car.DieselEngine
import com.example.dagger.car.Engine
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
 class DieselEngineModule(private val horsePower: Int) {

    /*@Binds
    abstract fun bindEngine(engine: DieselEngine): Engine*/
    @Provides
     fun provideEngine(): Engine {
        return DieselEngine(horsePower)
    }
}