package com.example.onlineshopprojectkotlin.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.onlineshopprojectkotlin.Model.Products
import com.example.onlineshopprojectkotlin.databinding.ItemViewPager2HomeBinding


class ViewPager2AdapterHome(
    private val productsList: List<Products>
) : RecyclerView.Adapter<ViewPager2AdapterHome.ItemViewPager2>(){

    inner class ItemViewPager2 (val binding: ItemViewPager2HomeBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewPager2 {
        val binding = ItemViewPager2HomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewPager2(binding)
    }

    override fun getItemCount(): Int {
        return productsList.size
    }

    override fun onBindViewHolder(holder: ItemViewPager2, position: Int) {
        val image = productsList[position]
        val binding = holder.binding

        val imageUrl = image.image
        binding.ivViewPager2.load(imageUrl)


    }

}