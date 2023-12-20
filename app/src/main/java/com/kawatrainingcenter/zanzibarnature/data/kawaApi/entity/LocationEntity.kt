package com.kawatrainingcenter.zanzibarnature.data.kawaApi.entity

data class LocationEntity (
    val id: Int,
    val title: String,
    val description: String,
    val kawa: String?,
    val images: List<String>,
    val icons: List<String>,
    val location: String
)

data class LocationsEntity (
    val locations: List<LocationEntity>
)