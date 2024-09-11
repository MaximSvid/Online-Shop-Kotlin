package com.example.onlineshopprojectkotlin.Model

data class Products (
    val id: Int,
    val title: String,
    val image: String,
    val price: Int,
    val description: String,
    val brand: String,
    val model: String,
    val color: String?,
    val category: String,
    val discount: Int? //  kann gleich null sein
)
