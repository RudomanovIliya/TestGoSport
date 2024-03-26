package com.example.testgosport.presentation.menu.recyclerView

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testgosport.presentation.model.Meal

class MealsAdapter : RecyclerView.Adapter<MealViewHolder>() {
    private val items = mutableListOf<Meal>()
    lateinit var mealListener: MealListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        return MealViewHolder(parent, mealListener)
    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(meals: List<Meal>) {
        items.clear()
        items.addAll(meals)
        notifyDataSetChanged()
    }
}