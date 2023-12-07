package com.kawatrainingcenter.zanzibarnature.data.MockAPI.api

import com.kawatrainingcenter.zanzibarnature.data.MockAPI.entity.CompensationEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MockAPI {
    @GET("/compensation/getCompensationAmount?lonFrom={LONFROM}&latFrom={LATFROM}&lonTo={LONTO}&latTo={LATTO}&toCurrency={TOCURRENCY}")
    suspend fun getCompensation(
        @Path("LONFROM") lonFrom: Double,
        @Path("LATFROM") latFrom: Double,
        @Path("LONTO") lonTo: Double,
        @Path("LATTO") latTo: Double,
        @Path("TOCURRENCY") currency: String,
    ):Response<CompensationEntity>

    @GET("/compensation/getCompensationAmount?lonFrom=7.763385&latFrom=52.30907&lonTo=39.221184&latTo=6.218466&toCurrency=EUR")
    suspend fun getCompensationTest():Response<CompensationEntity>
}