package com.example.testgosport.di

import com.example.testgosport.data.remote.repository.MealRepository
import com.example.testgosport.data.remote.repository.MealsRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun provideMealsRepository(
        mealsRepository: MealsRepositoryImpl,
    ): MealRepository
}