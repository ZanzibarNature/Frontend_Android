package com.kawatrainingcenter.zanzibarnature.ui.pages.explore.location_detail.state

import com.kawatrainingcenter.zanzibarnature.data.kawaApi.model.Location

sealed class LocationState {
    data class Success(
        val location: Location
    ): LocationState()

    object Loading: LocationState()

    data class Error(val message: String): LocationState()
}