package com.example.dagger.di.main

import com.example.dagger.ui.main.posts.PostsFragment
import com.example.dagger.ui.main.profile.ProfileFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributeProfileFragment(): ProfileFragment
    @ContributesAndroidInjector
    abstract fun contributePostFragment(): PostsFragment

}