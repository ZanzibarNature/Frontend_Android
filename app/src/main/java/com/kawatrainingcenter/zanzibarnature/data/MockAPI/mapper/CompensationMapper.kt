package com.kawatrainingcenter.zanzibarnature.data.MockAPI.mapper

import com.kawatrainingcenter.zanzibarnature.data.MockAPI.entity.CompensationEntity
import com.kawatrainingcenter.zanzibarnature.data.MockAPI.model.Compensation
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