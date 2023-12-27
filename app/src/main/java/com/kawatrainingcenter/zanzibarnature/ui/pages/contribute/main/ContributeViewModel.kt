package com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.main

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ContributeViewModel @Inject constructor(

) : ViewModel() {

    private val mutableEntered = MutableStateFlow(0)
    val entered: StateFlow<Int> = mutableEntered


    fun updateEntered(amount: Int) {
        mutableEntered.tryEmit(amount)
    }

}