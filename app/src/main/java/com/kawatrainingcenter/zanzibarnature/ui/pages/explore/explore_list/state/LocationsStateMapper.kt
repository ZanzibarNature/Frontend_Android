package com.kawatrainingcenter.zanzibarnature.ui.pages.explore.explore_list.state

import com.kawatrainingcenter.zanzibarnature.data.kawaApi.model.Locations
import javax.inject.Inject

class LocationsStateMapper @Inject constructor() {
    fun map(
        locations: Locations
    ): LocationsState {
        return LocationsState.Success(
            locations
        )
    }
}