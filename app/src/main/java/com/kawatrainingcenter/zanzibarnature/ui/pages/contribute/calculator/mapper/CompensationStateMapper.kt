package com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.calculator.mapper

import com.kawatrainingcenter.zanzibarnature.data.kawaApi.model.Compensation
import com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.calculator.model.CompensationState
import javax.inject.Inject

class CompensationStateMapper @Inject constructor() {
    fun map(
        compensation: Compensation
    ): CompensationState {
        return CompensationState.Success(
            compensation
        )
    }
}