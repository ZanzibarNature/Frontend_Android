package com.kawatrainingcenter.zanzibarnature.ui.pages.dashboard

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kawatrainingcenter.zanzibarnature.R
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.store.FavouriteStore
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.model.Location
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.repository.KawaRepository
import com.kawatrainingcenter.zanzibarnature.ui.pages.explore.explore_list.state.LocationsState
import com.kawatrainingcenter.zanzibarnature.ui.pages.explore.explore_list.state.LocationsStateMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val kawaRepository: KawaRepository,
    private val locationsStateMapper: LocationsStateMapper
) : ViewModel() {
    private val store = FavouriteStore(context)

    private val locationsFetched = MutableStateFlow<List<Location>>(emptyList())

    private val _locations = MutableStateFlow<LocationsState>(LocationsState.Loading)
    val locations: StateFlow<LocationsState> = _locations

    init { loadPage() }

    fun loadPage() {
        viewModelScope.launch { fetchLocations() }
    }

    fun reloadFavourites() {
        viewModelScope.launch { filterLocations() }
    }

    private suspend fun filterLocations() {
        val favourites = store.getFavouriteIds.first()

        val locations = locationsFetched.value.filter { location ->
            favourites.contains(location.id)
        }

        _locations.value = locationsStateMapper.map(locations)
    }

    private suspend fun fetchLocations() {
        _locations.value = LocationsState.Loading

        kawaRepository.getLocations()
            .onSuccess {
                locationsFetched.value = it.locations
                filterLocations()
            }
            .getOrElse {
                _locations.value = LocationsState.Error(
                    it.message ?: context.getString(R.string.error_message)
                )
            }
    }
}