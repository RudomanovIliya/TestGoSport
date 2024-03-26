package com.example.testgosport.data.remote.model

import com.example.testgosport.presentation.model.Meal
import com.google.gson.annotations.SerializedName

class ApiMeal(
    @SerializedName("strMeal") val titleMeal: String?,
    @SerializedName("strMealThumb") val imgUrl: String?,
    @SerializedName("strCategory") val category: String?,
    @SerializedName("strIngredient1") val ingridient1: String?,
    @SerializedName("strIngredient2") val ingridient2: String?,
    @SerializedName("strIngredient3") val ingridient3: String?,
    @SerializedName("strIngredient4") val ingridient4: String?,
    @SerializedName("strIngredient5") val ingridient5: String?,
)

fun ApiMeal.toModel(): Meal {
    return Meal(
        titleMeal = titleMeal.orEmpty(),
        imgUrl = imgUrl.orEmpty(),
        category = category.orEmpty(),
        ingridient1 = ingridient1.orEmpty(),
        ingridient2 = ingridient2.orEmpty(),
        ingridient3 = ingridient3.orEmpty(),
        ingridient4 = ingridient4.orEmpty(),
        ingridient5 = ingridient5.orEmpty(),
    )
}