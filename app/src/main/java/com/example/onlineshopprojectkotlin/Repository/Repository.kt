package com.example.onlineshopprojectkotlin.Repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.onlineshopprojectkotlin.Model.Products
import com.example.onlineshopprojectkotlin.Remote.OnlineShopApi

class Repository () {

    private val _productsList = MutableLiveData<List<Products>>()
    val productsList: LiveData<List<Products>> = _productsList

    private val _limitedProductsList = MutableLiveData<List<Products>>()
    val limitedProductsList: LiveData<List<Products>> = _limitedProductsList

    private var allProductsList = listOf<Products>()  // Храним полный список для сброса



    suspend fun loadProducts () {
        try {
            val response = OnlineShopApi.retrofitService.loadProducts()
            _productsList.postValue(response.products)
            Log.i("RepositoryLog", "fun loadProducts done")
        } catch (e: Exception) {
            Log.e("RepositoryLog", "loadProducts ${e.message.toString()}")
        }
    }

    suspend fun load3Images () {
        try {
            val resposne = OnlineShopApi.retrofitService.load5Images()
            _limitedProductsList.postValue(resposne.products)
            Log.i("RepositoryLog", "fun load3Images done")
        } catch (e:Exception) {
            Log.e("RepositoryLog", "load3Images ${e.message.toString()}")
        }
    }

    fun searchProduct(query: String) {
        val currentProduct = productsList.value ?: emptyList()
        val filteredProduct = currentProduct.filter {
            it.title.contains(query, ignoreCase = true)
        }
        _productsList.postValue(filteredProduct)
    }

    fun resetProducts () {
        _productsList.postValue(allProductsList)
    }
}