package com.example.testgosport.data.remote.model

import com.example.testgosport.presentation.model.CategoryInfo
import com.google.gson.annotations.SerializedName

class ApiCategoryInfo(
    @SerializedName("strCategory") val titleCategory: String?,
)

fun ApiCategoryInfo.toModel(): CategoryInfo {
    return CategoryInfo(
        titleCategory = titleCategory.orEmpty()
    )
}