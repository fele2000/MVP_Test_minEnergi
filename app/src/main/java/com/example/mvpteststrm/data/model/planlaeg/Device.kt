package com.example.mvpteststrm.data.model.planlaeg

data class Device(
    val name: String,
    val icon: Int,
    val timeRange: String,
    val color: Long,
    val date: String // Datoen enheden er tilknyttet
)
