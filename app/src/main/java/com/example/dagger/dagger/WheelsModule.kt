package com.example.dagger.dagger

import com.example.dagger.car.Wheels
import com.example.dagger.car.thirdparty.Rims
import com.example.dagger.car.thirdparty.Tires
import dagger.Module
import dagger.Provides

@Module
class WheelsModule {

    @Provides
     fun provideRims() : Rims {
        return Rims()
    }

    @Provides
    fun provideTires() : Tires {
        val tires = Tires()
        tires.inflate()
        return tires
    }

    @Provides
    fun provideWheels(rims: Rims, tires: Tires) : Wheels {
        return Wheels(rims, tires)
    }
}