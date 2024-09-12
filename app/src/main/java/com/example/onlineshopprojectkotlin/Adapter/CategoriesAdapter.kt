package com.example.onlineshopprojectkotlin.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshopprojectkotlin.Model.Products
import com.example.onlineshopprojectkotlin.databinding.ItemViewholderCategoryBinding

class CategoriesAdapter(
    private val productsList: List<Products>
) : RecyclerView.Adapter<CategoriesAdapter.ItemViewHolder>() {
    inner class ItemViewHolder(val binding: ItemViewholderCategoryBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoriesAdapter.ItemViewHolder {
        val binding = ItemViewholderCategoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoriesAdapter.ItemViewHolder, position: Int) {
        val category = productsList[position]
        val binding = holder.binding

        binding.tvCategory.text = category.category.toString()
    }

    override fun getItemCount(): Int {
        return productsList.size
    }
}
