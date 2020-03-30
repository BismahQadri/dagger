package com.example.dagger

import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class DieselEngineModule {

    @Binds
    abstract fun bindEngine(engine: DieselEngine): Engine
}