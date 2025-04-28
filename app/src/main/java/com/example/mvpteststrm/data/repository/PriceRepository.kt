package com.example.mvpteststrm.data.repository

import com.example.mvpteststrm.data.model.Price
import com.example.mvpteststrm.data.remote.RetrofitClient

class PriceRepository {
    private val apiService = RetrofitClient.apiService

    suspend fun fetchPrices(): List<Price> {
        return apiService.getPrices()
    }
}