package com.example.onlineshopprojectkotlin.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlineshopprojectkotlin.Model.Products
import com.example.onlineshopprojectkotlin.Repository.Repository
import kotlinx.coroutines.launch

class SearchViewModel: ViewModel() {

    private val repository = Repository()
    val productsList = repository.productsList


    init {
        loadProducts()
    }


    fun loadProducts() {
        viewModelScope.launch {
            repository.loadProducts()
        }
    }

    fun searchProduct (query: String) {
        viewModelScope.launch {
            repository.searchProduct(query)
        }
    }

    fun resetProductsList () {
        repository.resetProducts()
    }
}