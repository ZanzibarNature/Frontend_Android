package com.kawatrainingcenter.zanzibarnature.ui.pages.explore.location_detail.state

import com.kawatrainingcenter.zanzibarnature.data.kawaApi.model.Location
import javax.inject.Inject

class LocationStateMapper @Inject constructor() {
    fun map(
        location: Location
    ): LocationState {
        return LocationState.Success(
            location
        )
    }
}