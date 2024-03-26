package com.example.testgosport.presentation.menu.recyclerView

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testgosport.R

class AddsAdapter : RecyclerView.Adapter<AddViewHolder>() {
    private val items = mutableListOf(R.drawable.drawable_add, R.drawable.drawable_add_2)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddViewHolder {
        return AddViewHolder(parent)
    }

    override fun onBindViewHolder(holder: AddViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return 2
    }
}