package com.example.mvpteststrm.data.repository

import com.example.mvpteststrm.data.model.Price
import com.example.mvpteststrm.data.remote.RetrofitClient

// Vi havde problemer med API'et, så vi valgte ikke at bruge dette kode, men lave mockup data i PriceViewModel

class PriceRepository {
    private val apiService = RetrofitClient.apiService

    suspend fun fetchPrices(): List<Price> {
        return apiService.getPrices()
    }
}