package com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.calculator.model

typealias Airports = List<Airport>

data class Airport (
    val iata: String,
    val lon: String,
    val iso: String,
    val status: Long,
    val name: String? = null,
    val continent: Continent,
    val lat: String,
)

enum class Continent {
    AF,
    As,
    Eu,
    Na,
    Oc,
    Sa
}