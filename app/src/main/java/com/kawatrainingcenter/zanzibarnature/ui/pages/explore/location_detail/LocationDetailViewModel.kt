package com.kawatrainingcenter.zanzibarnature.ui.pages.explore.location_detail

import android.content.Context
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kawatrainingcenter.zanzibarnature.R
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.repository.KawaRepository
import com.kawatrainingcenter.zanzibarnature.ui.pages.explore.explore_list.state.LocationsState
import com.kawatrainingcenter.zanzibarnature.ui.pages.explore.location_detail.state.LocationState
import com.kawatrainingcenter.zanzibarnature.ui.pages.explore.location_detail.state.LocationStateMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocationDetailViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val kawaRepository: KawaRepository,
    private val savedStateHandle: SavedStateHandle,
    private val locationStateMapper: LocationStateMapper
): ViewModel() {

    private val _location = MutableStateFlow<LocationState>(LocationState.Loading)
    val location: StateFlow<LocationState> = _location

    init {
        viewModelScope.launch {
            savedStateHandle.getStateFlow("location_id", -1)
                .collectLatest { id ->
                    fetchLocation(id = id)
                }
        }
    }

    private fun fetchLocation(id: Int) {
        _location.value = LocationState.Loading

        kawaRepository.getLocation(id = id)
            .onSuccess {  _location.value = locationStateMapper.map(it) }
            .getOrElse {
                _location.value = LocationState.Error(
                    it.message ?: context.getString(R.string.error_message)
                )
            }
    }
}