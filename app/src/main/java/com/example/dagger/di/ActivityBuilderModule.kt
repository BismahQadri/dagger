package com.example.dagger.di

import com.example.dagger.AuthActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
 abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributesAuthActivity(): AuthActivity



}