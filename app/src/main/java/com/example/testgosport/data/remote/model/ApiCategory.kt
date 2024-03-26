package com.example.testgosport.data.remote.model

import com.example.testgosport.presentation.model.Category
import com.google.gson.annotations.SerializedName

class ApiCategory(
    @SerializedName("categories") val categories: List<ApiCategoryInfo>?
)

fun ApiCategory.toModel(): Category {
    return Category(
        categories = categories?.map { it.toModel() } ?: listOf(),
    )
}