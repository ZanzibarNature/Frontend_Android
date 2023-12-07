package com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.calculator

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kawatrainingcenter.zanzibarnature.R
import com.kawatrainingcenter.zanzibarnature.data.MockAPI.repository.MockRepository
import com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.calculator.mapper.CompensationStateMapper
import com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.calculator.model.CompensationState
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CalculatorViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val mockRepository: MockRepository,
    private val compensationStateMapper: CompensationStateMapper
) : ViewModel() {

    private val mutableState = MutableStateFlow<CompensationState>(CompensationState.Loading)
    val state: StateFlow<CompensationState> = mutableState

    init {
        getCompensation()
    }
    private fun getCompensation() {
        viewModelScope.launch { fetchCompensation() }
    }

    private suspend fun fetchCompensation() {
        mockRepository.getCompensation()
            .onSuccess { mutableState.value = compensationStateMapper.map(it) }
            .getOrElse {
                mutableState.value = CompensationState.Error(
                    it.message ?: context.getString(R.string.general_unknown_error)
                )
            }
    }
}