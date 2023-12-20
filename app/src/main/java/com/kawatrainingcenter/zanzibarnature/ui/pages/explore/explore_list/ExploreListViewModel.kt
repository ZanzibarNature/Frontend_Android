package com.kawatrainingcenter.zanzibarnature.ui.pages.explore.explore_list

import android.content.Context
import androidx.lifecycle.ViewModel
import com.kawatrainingcenter.zanzibarnature.R
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.model.Location
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.model.Locations
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.repository.KawaRepository
import com.kawatrainingcenter.zanzibarnature.ui.pages.explore.explore_list.state.LocationsState
import com.kawatrainingcenter.zanzibarnature.ui.pages.explore.explore_list.state.LocationsStateMapper
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


@HiltViewModel
class ExploreListViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val kawaRepository: KawaRepository,
    private val locationsStateMapper: LocationsStateMapper
) : ViewModel() {

    //val locations: Locations = kawaRepository.getLocationsMock()

    private val _locations = MutableStateFlow<LocationsState>(LocationsState.Loading)
    val locations: StateFlow<LocationsState> = _locations

    init {
        fetchLocations()
    }

    private fun fetchLocations() {
        _locations.value = LocationsState.Loading

        kawaRepository.getLocations()
            .onSuccess {  _locations.value = locationsStateMapper.map(it) }
            .getOrElse {
                _locations.value = LocationsState.Error(
                    it.message ?: context.getString(R.string.error_message)
                )
            }
    }
    
    
    
}