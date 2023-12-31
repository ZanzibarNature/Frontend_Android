package com.kawatrainingcenter.zanzibarnature.ui.pages.explore.explore_list

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kawatrainingcenter.zanzibarnature.R
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.helper.FavouriteStore
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.repository.KawaRepository
import com.kawatrainingcenter.zanzibarnature.ui.pages.explore.explore_list.state.LocationsState
import com.kawatrainingcenter.zanzibarnature.ui.pages.explore.explore_list.state.LocationsStateMapper
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch


@HiltViewModel
class ExploreListViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val kawaRepository: KawaRepository,
    private val locationsStateMapper: LocationsStateMapper
) : ViewModel() {

    private val store = FavouriteStore(context)

    private val _favourites = MutableStateFlow<Set<Int>>(emptySet())
    val favourites: StateFlow<Set<Int>> = _favourites

    private val _locations = MutableStateFlow<LocationsState>(LocationsState.Loading)
    val locations: StateFlow<LocationsState> = _locations

    init {
        fetchLocations(sortType = "")
        fetchFavorites()
    }

    fun fetchLocations(sortType: String) {
        _locations.value = LocationsState.Loading

        kawaRepository.getLocations()
            .onSuccess {
                val locations = if(sortType == "") it.locations
                    else { it.locations.filter { location ->
                    location.icons.contains(sortType) }
                }
                _locations.value = locationsStateMapper.map(locations)
            }
            .getOrElse {
                _locations.value = LocationsState.Error(
                    it.message ?: context.getString(R.string.error_message)
                )
            }
    }

    private fun fetchFavorites() {
        viewModelScope.launch {
            _favourites.value = store.getFavouriteIds.first()
        }
    }

    fun reloadFavorites() {
        fetchFavorites()
    }

}