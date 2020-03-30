package com.example.dagger.dagger

import com.example.dagger.MainActivity
import com.example.dagger.car.Car
import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent
import javax.inject.Named

@PerActivity
@Subcomponent( modules = [WheelsModule::class, PetrolEngineModule::class])
interface ActivityComponent {
    fun getCar(): Car
    fun inject(mainActivity: MainActivity)

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        fun horsePower(@Named ("horse power") horsePower: Int): Builder

        @BindsInstance
        fun capacityEngine(@Named ("engine capacity") capacityEngine: Int): Builder


        fun build(): ActivityComponent
    }
}