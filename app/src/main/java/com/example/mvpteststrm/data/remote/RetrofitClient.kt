package com.example.mvpteststrm.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


// Vi havde problemer med API'et, så vi valgte ikke at bruge dette kode, men lave mockup data i PriceViewModel
object RetrofitClient {

    private const val BASE_URL = "Api"

    val apiService: PriceApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PriceApiService::class.java) //forbindelse til priceapiservice
    }
}
