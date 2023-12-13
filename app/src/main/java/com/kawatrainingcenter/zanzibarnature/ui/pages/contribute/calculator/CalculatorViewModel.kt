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
import com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.calculator.model.Airports
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

    private val mutableState = MutableStateFlow<CompensationState>(CompensationState.Loading)
    val state: StateFlow<CompensationState> = mutableState

    private val mutableAirport = MutableStateFlow<List<Airport>?>(null)
    val airportState: StateFlow<List<Airport>?> = mutableAirport

    private val gson = Gson()
    private val airportType = object : TypeToken<List<Airport>>() {}.type
    private val airportsJson = getJsonDataFromAsset(context, "airports.json")
    private val airports: List<Airport> = gson.fromJson(airportsJson, airportType)

    init {
        getCompensation()
    }

    fun filterAirports(text: String) {
        mutableAirport.value = airports.filter { it.name?.contains(text, ignoreCase = true) == true }
    }

    private fun getCompensation() {
        viewModelScope.launch { fetchCompensation() }
    }

    private suspend fun fetchCompensation() {
        kawaRepository.getCompensation()
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