package com.example.testgosport.presentation.menu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testgosport.data.remote.repository.MealRepository
import com.example.testgosport.presentation.State
import com.example.testgosport.presentation.model.CategoryInfo
import com.example.testgosport.presentation.model.Meal
import kotlinx.coroutines.launch
import javax.inject.Inject

class MenuViewModel @Inject constructor(
    private val repository: MealRepository,
) : ViewModel() {
    private val _mealsLiveData = MutableLiveData<State<List<Meal>>>()
    val mealsLiveData: LiveData<State<List<Meal>>> = _mealsLiveData

    private val _categoriesLiveData = MutableLiveData<State<List<CategoryInfo>>>()
    val categoriesLiveData: LiveData<State<List<CategoryInfo>>> = _categoriesLiveData
    fun loadMeals() {
        viewModelScope.launch {
            try {
                val meals = repository.getMeals()
                _mealsLiveData.postValue(State.Data(meals.meals))
            } catch (e: Exception) {
                _mealsLiveData.postValue(State.Error(e))
            }
        }
    }

    fun loadCategories() {
        viewModelScope.launch {
            try {
                val categories = repository.getCategories()
                _categoriesLiveData.postValue(State.Data(categories.categories))
            } catch (e: Exception) {
                _categoriesLiveData.postValue(State.Error(e))
            }
        }
    }
}