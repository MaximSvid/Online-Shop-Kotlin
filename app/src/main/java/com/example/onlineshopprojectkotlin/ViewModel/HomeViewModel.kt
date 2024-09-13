package com.example.onlineshopprojectkotlin.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlineshopprojectkotlin.Repository.Repository
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {

    private val repository = Repository()
    val productsList = repository.productsList
    val limitedProductsList = repository.limetedProductsList

    init {
        loadProducts()
        load5Images()
    }

    fun loadProducts () {
        viewModelScope.launch {
            repository.loadProducts()
        }
    }

    fun load5Images () {
        viewModelScope.launch {
            repository.load5Images()
        }
    }
}