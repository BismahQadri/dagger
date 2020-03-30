package com.example.dagger

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dagger.car.Car
import com.example.dagger.dagger.DaggerCarComponent
import com.example.dagger.dagger.DieselEngineModule
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var car1: Car
    @Inject
    lateinit var car2: Car

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //val component = DaggerCarComponent.create() // when no arguments is taken by module in app , we use create
     /*   val component = DaggerCarComponent.builder()
                            .dieselEngineModule(DieselEngineModule(100))
                            .build()*/
        val component = DaggerCarComponent.builder()
            .horsePower(100)
            .capacityEngine(120)
            .build()
        component.inject(this)
        // car = component.getCar()
        car1.drive()
        car2.drive()
    }
}
