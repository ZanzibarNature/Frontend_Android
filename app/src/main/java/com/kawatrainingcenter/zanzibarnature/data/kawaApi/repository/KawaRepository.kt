package com.kawatrainingcenter.zanzibarnature.data.kawaApi.repository

import com.kawatrainingcenter.zanzibarnature.data.kawaApi.extensions.flatten
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.api.KawaApi
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.mapper.CompensationMapper
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.mapper.LocationMapper
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.mapper.ProjectMapper
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.mapper.ResponseMapper
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.model.Compensation
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.model.Location
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.model.Locations
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.model.Project
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.model.Projects
import com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.calculator.model.Airport
import javax.inject.Inject

class KawaRepository @Inject constructor(
    private val kawaApi: KawaApi,
    private val responseMapper: ResponseMapper,
    private val locationMapper: LocationMapper,
    private val projectMapper: ProjectMapper,
    private val compensationMapper: CompensationMapper,
) {
    suspend fun getCompensation(
        from: Airport,
        to: Airport,
        currency: String,
        tickets: Int,
        oneway: Int
    ): Result<Compensation> {
        return runCatching {
            kawaApi.getCompensation(
                lonFrom = from.lon,
                latFrom = from.lat,
                lonTo = to.lon,
                latTo = to.lat,
                currency = currency
            )
        }
            .map(responseMapper::map).flatten()
            .map { compensationMapper.map(it, tickets, oneway) }.flatten()
    }

    suspend fun getLocations(): Result<Locations> {
        return runCatching { kawaApi.getLocations() }
            .map(responseMapper::map).flatten()
            .map(locationMapper::mapList).flatten()
    }

    suspend fun getLocation(id: String): Result<Location> {
        return runCatching { kawaApi.getLocation(id) }
            .map(responseMapper::map).flatten()
            .map(locationMapper::map).flatten()
    }

    suspend fun getProjects(): Result<Projects> {
        return runCatching { kawaApi.getProjects() }
            .map(responseMapper::map).flatten()
            .map(projectMapper::mapList).flatten()
    }

    suspend fun getProject(id: String): Result<Project> {
        return runCatching { kawaApi.getProject(id) }
            .map(responseMapper::map).flatten()
            .map(projectMapper::map).flatten()
    }

}