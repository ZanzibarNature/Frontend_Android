package com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.calculator.model

typealias Airports = List<Airport>

data class Airport (
    val iata: String,
    val lon: String? = null,
    val iso: String,
    val status: Long,
    val name: String? = null,
    val continent: Continent,
    val lat: String? = null,
)

enum class Continent {
    AF,
    As,
    Eu,
    Na,
    Oc,
    Sa
}