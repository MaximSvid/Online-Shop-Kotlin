package com.example.onlineshopprojectkotlin.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.onlineshopprojectkotlin.Model.Products
import com.example.onlineshopprojectkotlin.databinding.ItemViewholderSalesBinding

class SalesAdapter (
    private val productsList: List<Products>
) : RecyclerView.Adapter<SalesAdapter.ItemViewHolder>(){

    private val sales = productsList.filter { it.onSale == true }

    inner class ItemViewHolder (val binding: ItemViewholderSalesBinding): RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SalesAdapter.ItemViewHolder {
        val binding = ItemViewholderSalesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SalesAdapter.ItemViewHolder, position: Int) {
        val saleProduct = sales[position]
        val binding = holder.binding

        binding.tvTitle.text = saleProduct.title.toString()
        binding.tvPrice.text = saleProduct.price.toString()

        val imageUrl = saleProduct.image
        binding.ivSales.load(imageUrl)
    }

    override fun getItemCount(): Int {
       return sales.size
    }
}