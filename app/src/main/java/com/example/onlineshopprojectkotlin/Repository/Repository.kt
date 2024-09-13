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
    val limetedProductsList: LiveData<List<Products>> = _limitedProductsList

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
            Log.i("RepositoryLog", "fun load5Images done")
        } catch (e:Exception) {
            Log.e("RepositoryLog", "load5Images ${e.message.toString()}")
        }
    }
}