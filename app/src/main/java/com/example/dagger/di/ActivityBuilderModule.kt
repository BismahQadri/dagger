package com.example.dagger.di

import com.example.dagger.di.auth.AuthModule
import com.example.dagger.di.auth.AuthViewModelsModule
import com.example.dagger.di.main.MainFragmentBuilderModule
import com.example.dagger.di.main.MainViewModelsModule
import com.example.dagger.ui.auth.AuthActivity
import com.example.dagger.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [AuthViewModelsModule::class, AuthModule::class])
    abstract fun contributesAuthActivity(): AuthActivity

    @ContributesAndroidInjector(modules = [MainFragmentBuilderModule::class, MainViewModelsModule::class])
    abstract fun contributesMainActivity(): MainActivity

}