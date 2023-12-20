package com.kawatrainingcenter.zanzibarnature.data.kawaApi.model


data class Location(
    val id: Int,
    val title: String,
    val description: String,
    val kawa: String?,
    val images: List<String>,
    val icons: List<String>,
    val location: String,
    //val url: String
)
data class Locations(
    val locations: List<Location>
)