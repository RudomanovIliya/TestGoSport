package com.example.testgosport.di

import androidx.lifecycle.ViewModel
import com.example.testgosport.presentation.menu.MenuViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MenuViewModel::class)
    abstract fun menuViewModel(viewModel: MenuViewModel): ViewModel
}