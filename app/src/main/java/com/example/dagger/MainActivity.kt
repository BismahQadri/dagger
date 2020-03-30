package com.example.dagger

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dagger.car.Car
import com.example.dagger.dagger.DaggerCarComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject   lateinit var  car: Car
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val component = DaggerCarComponent.create()
        component.inject(this)
       // car = component.getCar()
        car.drive()
    }
}
