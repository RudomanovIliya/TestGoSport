package com.example.testgosport.presentation.menu.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.testgosport.R
import com.example.testgosport.databinding.ItemAddsBinding

class AddViewHolder(
    parent: ViewGroup,
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_adds, parent, false)
) {
    private val binding by viewBinding(ItemAddsBinding::bind)
    fun bind(add: Int) {
        binding.imageViewAdd.setImageResource(add)
    }
}