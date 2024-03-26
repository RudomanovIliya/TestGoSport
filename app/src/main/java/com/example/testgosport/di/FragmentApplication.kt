package com.example.testgosport.di

import com.example.testgosport.presentation.menu.MenuFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun listBridgeFragment(): MenuFragment
}