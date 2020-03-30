package com.example.dagger.car

import android.util.Log
import javax.inject.Inject

class DieselEngine @Inject constructor() : Engine {
    override fun start() {
        Log.e("Car","Diesel engine started")
    }
}