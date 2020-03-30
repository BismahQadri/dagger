package com.example.dagger.car

import android.util.Log
import com.example.dagger.car.Car
import javax.inject.Inject

class Remote @Inject constructor() {

    fun setListener(car: Car){
        Log.e("Car","Remote Connected")
    }
}
