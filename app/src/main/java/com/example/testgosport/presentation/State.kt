package com.example.testgosport.presentation

sealed class State<T> {
    data class Data<T>(val data: T) : State<T>()
    data class Error<T>(val exception: Exception) : State<T>()
}