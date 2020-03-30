package com.example.dagger

import android.util.Log
import javax.inject.Inject

class PetrolEngine @Inject constructor(): Engine {
    override fun start() {
        Log.e("Car","Petrol engine started")
    }
}