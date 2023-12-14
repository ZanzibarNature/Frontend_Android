package com.kawatrainingcenter.zanzibarnature.data.kawaApi.api

import com.kawatrainingcenter.zanzibarnature.data.kawaApi.entity.CompensationEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface KawaApi {

    @GET("getCompensationAmount")
    suspend fun getCompensation(
        @Query("lonFrom") lonFrom: String,
        @Query("latFrom") latFrom: String,
        @Query("lonTo") lonTo: String,
        @Query("latTo") latTo: String,
        @Query("toCurrency") currency: String,
    ): Response<CompensationEntity>

    @GET("getCompensationAmount?lonFrom=7.763385&latFrom=52.30907&lonTo=39.221184&latTo=6.218466&toCurrency=EUR")
    suspend fun getCompensationTest(): Response<CompensationEntity>
}