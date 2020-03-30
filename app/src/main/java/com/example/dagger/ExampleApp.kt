package com.example.dagger

import android.app.Application
import com.example.dagger.dagger.AppComponent
import com.example.dagger.dagger.DaggerAppComponent
import com.example.dagger.dagger.DriverModule

class ExampleApp : Application() {
    private lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.factory().create(DriverModule("Hans"))

    }

    fun getAppComponent() : AppComponent {
        return component
    }
}