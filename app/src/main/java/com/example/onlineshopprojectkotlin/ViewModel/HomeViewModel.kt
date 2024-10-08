package com.example.onlineshopprojectkotlin.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlineshopprojectkotlin.Repository.Repository
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val repository = Repository()
    val productsList = repository.productsList
    val limitedProductsList = repository.limitedProductsList

    init {
        loadProducts()
        load3Images()
    }

    fun loadProducts() {
        viewModelScope.launch {
            repository.loadProducts()
        }
    }

    fun load3Images() {
        viewModelScope.launch {
            repository.load3Images()
        }
    }


}