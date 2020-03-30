package com.example.dagger.car

import android.util.Log
import javax.inject.Inject

class DieselEngine  constructor(private val  horsePower: Int) : Engine {


    override fun start() {
        Log.e("Car","Diesel engine started. Horse Power: $horsePower")
    }
}