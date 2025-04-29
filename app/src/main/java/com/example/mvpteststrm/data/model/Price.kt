// Model-klasse der repræsenterer en strømpris for en time

package com.example.mvpteststrm.data.model

import com.google.gson.annotations.SerializedName


data class Price(
    @SerializedName("")
    val pricePerKwh: Double,
    @SerializedName("")
    val time: Int,


)

