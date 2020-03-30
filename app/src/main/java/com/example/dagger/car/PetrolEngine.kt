package com.example.dagger.car

import android.util.Log
import com.example.dagger.car.Engine
import javax.inject.Inject

class PetrolEngine @Inject constructor(): Engine {
    override fun start() {
        Log.e("Car","Petrol engine started")
    }
}