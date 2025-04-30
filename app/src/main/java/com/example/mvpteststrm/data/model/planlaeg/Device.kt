package com.example.mvpteststrm.data.model.planlaeg

data class Device(
    val name: String,
    val timeRange: String,
    val icon: Int,
    val color: Long,
    val date: String // Datoen enheden er tilknyttet
)
