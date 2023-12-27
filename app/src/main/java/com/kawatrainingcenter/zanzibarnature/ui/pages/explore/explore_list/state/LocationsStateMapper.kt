package com.kawatrainingcenter.zanzibarnature.ui.pages.explore.explore_list.state

import com.kawatrainingcenter.zanzibarnature.data.kawaApi.model.Location
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.model.Locations
import javax.inject.Inject

class LocationsStateMapper @Inject constructor() {
    fun map(
        locations: List<Location>
    ): LocationsState {
        return LocationsState.Success(
            locations
        )
    }
}