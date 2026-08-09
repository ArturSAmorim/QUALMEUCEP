package com.example.qualmeucep.data.repository

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
object ApiFactory {

    val apiCep= Retrofit.Builder()
        .baseUrl("https://viacep.com.br/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)
}