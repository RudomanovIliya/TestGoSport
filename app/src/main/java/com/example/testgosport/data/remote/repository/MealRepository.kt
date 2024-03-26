package com.example.testgosport.data.remote.repository

import com.example.testgosport.presentation.model.Category
import com.example.testgosport.presentation.model.Meals

interface MealRepository {

    suspend fun getMeals(): Meals

    suspend fun getCategories(): Category
}