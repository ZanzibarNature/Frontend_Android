package com.kawatrainingcenter.zanzibarnature.data.kawaApi.api

import com.kawatrainingcenter.zanzibarnature.data.kawaApi.entity.CompensationEntity
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.entity.LocationEntity
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.entity.LocationsEntity
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.entity.ProjectEntity
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.entity.ProjectsEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface KawaApi {

    @GET("https://compensation-kawa-foundation-app-dev.apps.ocp6-inholland.joran-bergfeld.com/getCompensationAmount")
    suspend fun getCompensation(
        @Query("lonFrom") lonFrom: String,
        @Query("latFrom") latFrom: String,
        @Query("lonTo") lonTo: String,
        @Query("latTo") latTo: String,
        @Query("toCurrency") currency: String,
    ): Response<CompensationEntity>

    @GET("api/Content/Locations/GetPage?maxPerPage=10")
    suspend fun getLocations(): Response<LocationsEntity>

    @GET("api/Content/Locations/GetByKey/Location/{id}")
    suspend fun getLocation(
        @Path("id") id: String
    ): Response<LocationEntity>

    @GET("api/Content/Articles/GetPage?maxPerPage=10")
    suspend fun getProjects(): Response<ProjectsEntity>

    @GET("api/Content/Articles/GetByKey/Project/{id}")
    suspend fun getProject(
        @Path("id") id: String
    ): Response<ProjectEntity>
}