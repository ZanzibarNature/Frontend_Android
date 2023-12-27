package com.kawatrainingcenter.zanzibarnature.ui.pages.explore.explore_list.state

import com.kawatrainingcenter.zanzibarnature.data.kawaApi.model.Location

sealed class LocationsState {
    data class Success(
        val locations: List<Location>
    ): LocationsState()

    object Loading: LocationsState()

    data class Error(val message: String): LocationsState()
}