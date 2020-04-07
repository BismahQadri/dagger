package com.example.dagger.di

import com.example.dagger.di.auth.AuthViewModelsModule
import com.example.dagger.ui.auth.AuthActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
 abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [AuthViewModelsModule::class])
    abstract fun contributesAuthActivity(): AuthActivity

}