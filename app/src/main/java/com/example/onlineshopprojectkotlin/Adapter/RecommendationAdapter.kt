package com.example.onlineshopprojectkotlin.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.onlineshopprojectkotlin.Model.Products
import com.example.onlineshopprojectkotlin.databinding.ItemViewholderRecommendedBinding

class RecommendationAdapter (
    private val productsList: List<Products>
) : RecyclerView.Adapter<RecommendationAdapter.ItemViewHolder>(){

    inner class ItemViewHolder (val binding: ItemViewholderRecommendedBinding): RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecommendationAdapter.ItemViewHolder {
        val binding = ItemViewholderRecommendedBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecommendationAdapter.ItemViewHolder, position: Int) {
        val product = productsList[position]
        val binding = holder.binding

        binding.tvTitle.text = product.title.toString()
        binding.tvIdNumber.text = product.id.toString()
        binding.tvPrice.text = product.price.toString()

        val imageUrl = product.image
        binding.ivRecommended.load(imageUrl)
    }

    override fun getItemCount(): Int {
       return productsList.size
    }
}