package com.example.onlineshopprojectkotlin.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshopprojectkotlin.databinding.ItemViewholderRecommendedBinding

class RecommendationAdapter (
    private val recommendationList: List<*>
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
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
       return recommendationList.size
    }
}