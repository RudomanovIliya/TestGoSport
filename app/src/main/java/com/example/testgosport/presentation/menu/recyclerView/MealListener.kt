package com.example.testgosport.presentation.menu.recyclerView

import com.example.testgosport.presentation.model.Meal

fun interface MealListener {
    fun onMealClick(meal: Meal)
}