package com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.calculator

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.kawatrainingcenter.zanzibarnature.R
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.repository.KawaRepository
import com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.calculator.mapper.CompensationStateMapper
import com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.calculator.model.Airport
import com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.calculator.model.CompensationState
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class CalculatorViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val kawaRepository: KawaRepository,
    private val compensationStateMapper: CompensationStateMapper
) : ViewModel() {

    private val mutableState = MutableStateFlow<CompensationState>(CompensationState.NotClicked)
    val state: StateFlow<CompensationState> = mutableState

    private val mutableAirport = MutableStateFlow<List<Airport>?>(null)
    val airportState: StateFlow<List<Airport>?> = mutableAirport

    private val gson = Gson()
    private val airportType = object : TypeToken<List<Airport>>() {}.type
    private val airportsJson = getJsonDataFromAsset(context, "airports.json")
    private val airports: List<Airport> = gson.fromJson(airportsJson, airportType)

    private val mutableEntered = MutableStateFlow(0)
    val entered: StateFlow<Int> = mutableEntered

    fun updateEntered(amount: Int) {
        mutableEntered.tryEmit(amount)
    }

    fun filterAirports(text: String) {
        mutableAirport.value = airports.filter { it.name?.contains(text, ignoreCase = true) == true }
    }

    fun getCompensation(from: Airport, to: Airport, tickets: Int, oneway: Boolean) {
        mutableState.value = CompensationState.Loading
        viewModelScope.launch { fetchCompensation(from = from, to = to, tickets = tickets, oneway = oneway) }
    }

    private suspend fun fetchCompensation(from: Airport, to: Airport, tickets: Int, oneway: Boolean) {
        val oneway2: Int = if(oneway) 1 else 2
        kawaRepository.getCompensation(from = from, to = to, currency = "EUR", tickets = tickets, oneway = oneway2)
            .onSuccess { mutableState.value = compensationStateMapper.map(it) }
            .getOrElse {
                mutableState.value = CompensationState.Error(
                    it.message ?: context.getString(R.string.general_unknown_error)
                )
            }
    }

    private fun getJsonDataFromAsset(context: Context, fileName: String): String {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return ""
        }
        return jsonString
    }


}