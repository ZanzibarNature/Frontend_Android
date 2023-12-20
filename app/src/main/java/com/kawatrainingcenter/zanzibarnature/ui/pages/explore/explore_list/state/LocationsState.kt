package com.kawatrainingcenter.zanzibarnature.ui.pages.explore.explore_list.state

import com.kawatrainingcenter.zanzibarnature.data.kawaApi.model.Locations
sealed class LocationsState {
    data class Success(
        val locations: Locations
    ): LocationsState()

    object Loading: LocationsState()

    data class Error(val message: String): LocationsState()
}