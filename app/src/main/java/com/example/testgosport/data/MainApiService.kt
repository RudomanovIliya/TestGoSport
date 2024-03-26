package com.example.testgosport.data

import com.example.testgosport.data.remote.model.ApiCategory
import com.example.testgosport.data.remote.model.ApiMeals
import retrofit2.http.GET

interface MainApiService {
    @GET("search.php?s")
    suspend fun getMeals(): ApiMeals

    @GET("categories.php")
    suspend fun getCategories(): ApiCategory
}