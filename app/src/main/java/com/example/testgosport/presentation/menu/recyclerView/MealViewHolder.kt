package com.example.testgosport.presentation.menu.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.testgosport.R
import com.example.testgosport.databinding.ItemMealBinding
import com.example.testgosport.presentation.model.Meal

class MealViewHolder(
    parent: ViewGroup,
    private val mealListener: MealListener,
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_meal, parent, false)
) {
    private val binding by viewBinding(ItemMealBinding::bind)
    fun bind(meal: Meal) {
        binding.root.setOnClickListener {
            mealListener.onMealClick(meal)
        }
        binding.textViewTitle.text = meal.titleMeal
        Glide.with(binding.root)
            .load(meal.imgUrl)
            .into(binding.imageViewMeal)
        val stringBuilderIngridients = StringBuilder()
        stringBuilderIngridients.append(meal.ingridient1).append(", ").append(meal.ingridient2)
            .append(", ").append(meal.ingridient3).append(", ").append(meal.ingridient4)
            .append(", ").append(meal.ingridient5)
        binding.textViewIngridients.text=(stringBuilderIngridients)
    }
}