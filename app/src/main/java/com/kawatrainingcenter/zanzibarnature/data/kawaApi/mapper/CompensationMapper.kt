package com.kawatrainingcenter.zanzibarnature.data.kawaApi.mapper

import com.kawatrainingcenter.zanzibarnature.data.kawaApi.entity.CompensationEntity
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.model.Compensation
import javax.inject.Inject

class CompensationMapper @Inject constructor() {
    fun map(entity: CompensationEntity): Result<Compensation> {
        return runCatching {
            Compensation (
                total = entity.totalCost,
                currency = entity.currency
            )
        }
    }
}