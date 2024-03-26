package com.example.testgosport.presentation.menu.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.testgosport.R
import com.example.testgosport.databinding.ItemCategoryBinding
import com.example.testgosport.presentation.model.CategoryInfo

class CategoryViewHolder(
    parent: ViewGroup,
    private val categoryListener: CategoryListener,
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
) {
    private val binding by viewBinding (ItemCategoryBinding::bind)
    fun bind(categoryInfo: CategoryInfo) {
        binding.root.setOnClickListener {
            categoryListener.onCategoryClick(categoryInfo)
        }
        binding.textViewCategory.text=categoryInfo.titleCategory
    }
}