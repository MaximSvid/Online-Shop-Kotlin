package com.example.onlineshopprojectkotlin.Repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.onlineshopprojectkotlin.Model.Products
import com.example.onlineshopprojectkotlin.Remote.OnlineShopApi

class Repository () {

    private val _productsList = MutableLiveData<List<Products>>()
    val productsList: LiveData<List<Products>> = _productsList

    suspend fun loadProducts () {
        try {
            val response = OnlineShopApi.retrofitService.loadProducts()
            _productsList.postValue(response.products)
            Log.i("RepositoryLog", "fun loadProducts done")
        } catch (e: Exception) {
            Log.e("RepositoryLog", e.message.toString())
        }
    }
}