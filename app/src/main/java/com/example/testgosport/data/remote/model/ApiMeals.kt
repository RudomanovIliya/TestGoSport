package com.example.testgosport.data.remote.model

import com.example.testgosport.presentation.model.Meals
import com.google.gson.annotations.SerializedName

class ApiMeals(@SerializedName("meals") val meals: List<ApiMeal>?)

fun ApiMeals.toModel(): Meals {
    return Meals(
        meals = meals?.map { it.toModel() } ?: listOf(),
    )
}