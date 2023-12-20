package com.kawatrainingcenter.zanzibarnature.data.kawaApi.repository

import com.kawatrainingcenter.zanzibarnature.data.kawaApi.extensions.flatten
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.api.KawaApi
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.api.mockData
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.mapper.CompensationMapper
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.mapper.LocationMapper
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.mapper.ResponseMapper
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.model.Compensation
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.model.Locations
import com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.calculator.model.Airport
import java.util.Currency
import javax.inject.Inject

class KawaRepository @Inject constructor(
    private val kawaApi: KawaApi,
    private val responseMapper: ResponseMapper,
    private val locationMapper: LocationMapper,
    private val compensationMapper: CompensationMapper,
    private val mockData: mockData
) {
    suspend fun getCompensation(from: Airport, to: Airport, currency: String, tickets: Int ): Result<Compensation> {
        return runCatching {kawaApi.getCompensation(lonFrom = from.lon, latFrom = from.lat, lonTo = to.lon, latTo = to.lat, currency = currency)}
            .map(responseMapper::map).flatten()
            .map { compensationMapper.map(it, tickets) }.flatten()
    }

    fun getLocations(): Result<Locations> {
        return runCatching {mockData.getLocations()}
            .map(locationMapper::mapList).flatten()
    }

//    fun getLocationsMock(): Locations {
//        val locations = mockData.getLocations()
//        return locationMapper.mapList(locations)
//    }
}