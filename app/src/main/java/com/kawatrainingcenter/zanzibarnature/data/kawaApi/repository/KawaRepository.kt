package com.kawatrainingcenter.zanzibarnature.data.kawaApi.repository

import com.kawatrainingcenter.zanzibarnature.data.kawaApi.extensions.flatten
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.api.KawaApi
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.mapper.CompensationMapper
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.mapper.ResponseMapper
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.model.Compensation
import javax.inject.Inject

class KawaRepository @Inject constructor(
    private val kawaApi: KawaApi,
    private val responseMapper: ResponseMapper,
    private val compensationMapper: CompensationMapper
) {
    suspend fun getCompensation(): Result<Compensation> {
        return runCatching { kawaApi.getCompensationTest() }
            .map(responseMapper::map).flatten()
            .map(compensationMapper::map).flatten()
    }

}