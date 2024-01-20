package com.kawatrainingcenter.zanzibarnature.data.kawaApi.model


data class Location(
    val id: String,
    val title: String,
    val description: String,
    val kawa: String?,
    val images: List<String>,
    val icons: List<String>,
    val googleMapsUrl: String,
    val latitude: Double,
    val longitude: Double
)
data class Locations(
    val locations: List<Location>
)