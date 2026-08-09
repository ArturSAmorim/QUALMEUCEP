package com.example.qualmeucep.data.repository

import com.example.qualmeucep.data.model.Address
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("ws/{cep}/json/")
    suspend fun getAddress(@Path("cep") cep: String): Address
}
