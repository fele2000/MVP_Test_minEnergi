package com.example.mvpteststrm.data.remote

import com.example.mvpteststrm.data.model.Price
import retrofit2.http.GET

interface PriceApiService {
    @GET("Endpoint")
    suspend fun getPrices(): List<Price>
}