package com.example.onlineshopprojectkotlin.Remote

import com.example.onlineshopprojectkotlin.Model.Products
import com.example.onlineshopprojectkotlin.Model.ProductsResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://fakestoreapi.in/api/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private  val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface OnlineShopApiService {

    //@Get - wird verwendet, um Daten vom Server abzurufen
    @GET("products")
    suspend fun loadProducts (): ProductsResponse

    @GET("products?limit=3")
    suspend fun load5Images (): ProductsResponse

}

object OnlineShopApi {
    val retrofitService: OnlineShopApiService by lazy { retrofit.create(OnlineShopApiService::class.java) }
}