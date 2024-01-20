package com.kawatrainingcenter.zanzibarnature.data.kawaApi.entity

data class LocationEntity (
    val name: String,
    val description: String,
    val latitude: Double,
    val longitude: Double,
    val serializedIconNames: String,
    val googleMapsURL: String,
    val involvementHighlight: String?,
    val partitionKey: String,
    val rowKey: String,
    val serializedImageURLs: String
)

data class LocationsEntity (
    val item1: String?,
    val item2: List<LocationEntity>
)

//data class LocationEntity (
//    val id: Int,
//    val title: String,
//    val description: String,
//    val kawa: String?,
//    val images: List<String>,
//    val icons: List<String>,
//    val location: String,
//    val coords: List<Double>
//)
//
//data class LocationsEntity (
//    val locations: List<LocationEntity>
//)