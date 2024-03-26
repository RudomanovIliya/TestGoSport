package com.example.testgosport.presentation.menu.recyclerView

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testgosport.presentation.model.CategoryInfo

class CategoriesAdapter : RecyclerView.Adapter<CategoryViewHolder>() {
    private val items = mutableListOf<CategoryInfo>()
    lateinit var categoryListener: CategoryListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(parent, categoryListener)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(categories: List<CategoryInfo>) {
        items.clear()
        items.addAll(categories)
        notifyDataSetChanged()
    }
}