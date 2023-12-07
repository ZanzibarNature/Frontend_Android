package com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.main

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
class ContributeViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val mockRepository: MockRepository,
    private val compensationStateMapper: CompensationStateMapper
) : ViewModel() {

    private val mutableEntered = MutableStateFlow<Int>(0)
    val entered: StateFlow<Int> = mutableEntered


    fun updateEntered(amount: Int) {
        mutableEntered.tryEmit(amount)
    }

}