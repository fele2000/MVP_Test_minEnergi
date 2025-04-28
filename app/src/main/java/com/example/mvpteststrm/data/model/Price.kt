// Model-klasse der repræsenterer en strømpris for en time

package com.example.mvpteststrm.data.model

import com.google.gson.annotations.SerializedName


data class Price(
    @SerializedName("whatever ift api'et")
    val pricePerKwh: Double,
    @SerializedName("whatever ift api'et")
    val time: Int,

    val isNow: Boolean = false, //standard værdi, fordi dette ikke kommer fra api'et
    val isCheapest: Boolean = false, //standard værdi, fordi dette ikke kommer fra api'et
    val isMostExpensive: Boolean = false //standard værdi, fordi dette ikke kommer fra api'et
)

