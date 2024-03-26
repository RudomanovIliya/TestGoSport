package com.example.testgosport.presentation.menu.recyclerView

import com.example.testgosport.presentation.model.CategoryInfo

fun interface CategoryListener {
    fun onCategoryClick(categoryInfo: CategoryInfo)
}