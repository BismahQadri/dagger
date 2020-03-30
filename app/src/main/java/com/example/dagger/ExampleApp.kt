package com.example.dagger

import android.app.Application
import com.example.dagger.dagger.ActivityComponent
import com.example.dagger.dagger.AppComponent
import com.example.dagger.dagger.DaggerAppComponent

class ExampleApp : Application() {
    private lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        /*component = DaggerActivityComponent.builder()
            .horsePower(200)
            .capacityEngine(210)
            .build()*/
        component = DaggerAppComponent.create()
    }

    fun getAppComponent() : AppComponent {
        return component
    }
}