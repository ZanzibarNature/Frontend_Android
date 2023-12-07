package com.kawatrainingcenter.zanzibarnature.data.MockAPI.repository

import com.kawatrainingcenter.zanzibarnature.data.MockAPI.api.MockAPI
import com.kawatrainingcenter.zanzibarnature.data.MockAPI.extensions.flatten
import com.kawatrainingcenter.zanzibarnature.data.MockAPI.mapper.CompensationMapper
import com.kawatrainingcenter.zanzibarnature.data.MockAPI.mapper.ResponseMapper
import com.kawatrainingcenter.zanzibarnature.data.MockAPI.model.Compensation
import javax.inject.Inject

class MockRepository @Inject constructor(
    private val mockAPI: MockAPI,
    private val responseMapper: ResponseMapper,
    private val compensationMapper: CompensationMapper
) {
    suspend fun getCompensation(): Result<Compensation> {
        return runCatching { mockAPI.getCompensationTest() }
            .map(responseMapper::map).flatten()
            .map(compensationMapper::map).flatten()
    }

}