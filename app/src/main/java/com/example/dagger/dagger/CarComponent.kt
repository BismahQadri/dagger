package com.example.dagger.dagger

import com.example.dagger.MainActivity
import com.example.dagger.car.Car
import dagger.Component

@Component(modules =[WheelsModule::class, DieselEngineModule:: class])
interface CarComponent {
    fun getCar() : Car

    fun inject(mainActivity: MainActivity)
}