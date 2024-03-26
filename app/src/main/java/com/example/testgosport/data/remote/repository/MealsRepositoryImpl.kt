package com.example.testgosport.data.remote.repository

import com.example.testgosport.data.MainApiService
import com.example.testgosport.data.remote.model.toModel
import com.example.testgosport.presentation.model.Category
import com.example.testgosport.presentation.model.Meals
import javax.inject.Inject

class MealsRepositoryImpl @Inject constructor(
    private val apiService: MainApiService,
) : MealRepository {

    override suspend fun getMeals(): Meals {
        return apiService.getMeals().toModel()
    }
    override suspend fun getCategories(): Category {
        return apiService.getCategories().toModel()
    }
}