package com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.calculator.model

import com.kawatrainingcenter.zanzibarnature.data.kawaApi.model.Compensation

sealed class CompensationState {

    data class Success(
        val compensation: Compensation
    ): CompensationState()

    object Loading: CompensationState()

    data class Error(val message: String): CompensationState()
}