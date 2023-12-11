package com.kawatrainingcenter.zanzibarnature.data.MockAPI.model

data class Location(
    val id: Int,
    val title: String,
    val description: String,
    val kawa: String?,
    val image: String,
    val icons: List<String>,
    val location: String
)