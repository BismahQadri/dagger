package com.example.dagger.dagger

import com.example.dagger.MainActivity
import com.example.dagger.car.Car
import dagger.BindsInstance
import dagger.Component
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Component(modules = [WheelsModule::class, PetrolEngineModule::class])
interface CarComponent {
    fun getCar(): Car
    fun inject(mainActivity: MainActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun horsePower(@Named ("horse power") horsePower: Int): Builder

        @BindsInstance
        fun capacityEngine(@Named ("engine capacity") capacityEngine: Int): Builder

        fun build(): CarComponent
    }
}