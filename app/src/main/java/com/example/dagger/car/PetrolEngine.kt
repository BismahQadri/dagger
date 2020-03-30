package com.example.dagger.car

import android.util.Log
import javax.inject.Inject
import javax.inject.Named

class PetrolEngine @Inject constructor(
    @Named("horse power") private val horsePower: Int,
    @Named("engine capacity")private val engineCapacity: Int
) : Engine {

    override fun start() {
        Log.e("Car", "Petrol engine started.. HorsePower is $horsePower and engine capacity is $engineCapacity")
    }
}