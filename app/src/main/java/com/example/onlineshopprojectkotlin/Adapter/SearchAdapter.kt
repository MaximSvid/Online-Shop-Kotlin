package com.example.onlineshopprojectkotlin.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.onlineshopprojectkotlin.Model.Products
import com.example.onlineshopprojectkotlin.databinding.ItemViewholderSalesBinding
import com.example.onlineshopprojectkotlin.databinding.ItemViewholderSearchBinding

class SearchAdapter (
    private val productList: MutableList<Products>
) : RecyclerView.Adapter<SearchAdapter.ItemViewHolder>(){

    inner class ItemViewHolder(val binding: ItemViewholderSearchBinding):RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchAdapter.ItemViewHolder {
        val binding = ItemViewholderSearchBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchAdapter.ItemViewHolder, position: Int) {
        val product = productList[position]
        val binding = holder.binding

        binding.tvTitle.text = product.title.toString()
        binding.tvIdNumber.text = product.id.toString()
        binding.tvPrice.text = product.price.toString()

        val imageUrl = product.image
        binding.ivRecommended.load(imageUrl)

        if (product.onSale == true) {
            binding.ivSales.visibility = View.VISIBLE
        } else {
            binding.ivSales.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    fun updateAdapter (newProductList: List<Products>) {
        productList.clear()
        productList.addAll(newProductList)
        notifyDataSetChanged()

    }
}