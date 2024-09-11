package com.example.onlineshopprojectkotlin.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlineshopprojectkotlin.Repository.Repository
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {

    private val repository = Repository()
    val productsList = repository.productsList

    init {
        loadProducts()
    }

    fun loadProducts () {
        viewModelScope.launch {
            repository.loadProducts()
        }
    }
}