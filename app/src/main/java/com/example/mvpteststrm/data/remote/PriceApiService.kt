package com.example.mvpteststrm.data.remote

import com.example.mvpteststrm.data.model.price.Price
import retrofit2.http.GET
// Vi havde problemer med API'et, så vi valgte ikke at bruge dette kode, men lave mockup data i PriceViewModel

interface PriceApiService {
    @GET("Endpoint")
    suspend fun getPrices(): List<Price>
}