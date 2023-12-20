package com.kawatrainingcenter.zanzibarnature.data.kawaApi.mapper

import com.kawatrainingcenter.zanzibarnature.data.kawaApi.entity.LocationEntity
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.entity.LocationsEntity
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.model.Location
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.model.Locations
import javax.inject.Inject

class LocationMapper @Inject constructor() {

    fun map(entity: LocationEntity): Result<Location> {
        return runCatching {
            Location(
                id = entity.id,
                title = entity.title,
                description = entity.description,
                kawa = entity.kawa!!,
                images = entity.images,
                icons = entity.icons,
                location = entity.location
            )
        }
    }

    fun mapList(entity: LocationsEntity): Result<Locations> {
        return runCatching {
            Locations(
                locations = entity.locations.map { map(it).getOrThrow() }
            )
        }
    }
}