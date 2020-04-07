package com.example.dagger.di

import androidx.lifecycle.ViewModelProvider
import com.example.dagger.viewmodels.ViewModelProviderFactory
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelProviderFactory: ViewModelProviderFactory) : ViewModelProvider.Factory
}