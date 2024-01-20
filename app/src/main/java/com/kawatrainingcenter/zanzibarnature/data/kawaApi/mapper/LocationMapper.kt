package com.kawatrainingcenter.zanzibarnature.data.kawaApi.mapper

import com.kawatrainingcenter.zanzibarnature.data.kawaApi.entity.ImageUrls
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.entity.LocationEntity
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.entity.LocationsEntity
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.model.Location
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.model.Locations
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import javax.inject.Inject

class LocationMapper @Inject constructor() {

    fun map(entity: LocationEntity): Result<Location> {
        return runCatching {

            //The images from the backend are a serialized string, this method below converts them into a List<String>
            val serializedImageURLs = entity.serializedImageURLs
            val imageUrls = Json.decodeFromString<ImageUrls>(serializedImageURLs)
            val urlList = listOf(imageUrls.BannerImage, imageUrls.AdditionalImage1, imageUrls.AdditionalImage2)

            val serializedIconNames = entity.serializedIconNames
            val iconList: List<String> = Json.decodeFromString(serializedIconNames)

            Location(
                id = entity.rowKey,
                title = entity.name,
                description = entity.description,
                kawa = entity.involvementHighlight!!,
                images = urlList,
                icons = iconList,
                googleMapsUrl = entity.googleMapsURL,
                latitude = entity.latitude,
                longitude = entity.longitude
            )
        }
    }

    fun mapList(entity: LocationsEntity): Result<Locations> {
        return runCatching {
            Locations(
                locations = entity.item2.map { map(it).getOrThrow() }
            )
        }
    }
}