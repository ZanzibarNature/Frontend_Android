package com.kawatrainingcenter.zanzibarnature.ui.pages.explore.location_detail

import android.content.Context
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kawatrainingcenter.zanzibarnature.R
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.helper.FavouriteStore
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.repository.KawaRepository
import com.kawatrainingcenter.zanzibarnature.ui.pages.explore.explore_list.state.LocationsState
import com.kawatrainingcenter.zanzibarnature.ui.pages.explore.location_detail.state.LocationState
import com.kawatrainingcenter.zanzibarnature.ui.pages.explore.location_detail.state.LocationStateMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocationDetailViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val kawaRepository: KawaRepository,
    private val savedStateHandle: SavedStateHandle,
    private val locationStateMapper: LocationStateMapper
) : ViewModel() {

    private val _location = MutableStateFlow<LocationState>(LocationState.Loading)
    val location: StateFlow<LocationState> = _location

    private val _favourites = MutableStateFlow<Set<Int>>(emptySet())
    private val favourites: StateFlow<Set<Int>> = _favourites

    private val _isFav = MutableStateFlow(false)
    val isFav: StateFlow<Boolean> = _isFav

    private val store = FavouriteStore(context)

    init {
        viewModelScope.launch {
            savedStateHandle.getStateFlow("location_id", -1)
                .collectLatest { id ->
                    getFavourites(id = id)
                    fetchLocation(id = id)
                }
        }
    }

    fun addToFavourite(id: Int) {
        viewModelScope.launch {
            store.saveId(id)
            getFavourites(id = id)
        }
    }

    private fun fetchLocation(id: Int) {
        _location.value = LocationState.Loading

        kawaRepository.getLocation(id = id)
            .onSuccess {
                _location.value = locationStateMapper.map(it)
                _isFav.value = favourites.value.contains(id)
            }
            .getOrElse {
                _location.value = LocationState.Error(
                    it.message ?: context.getString(R.string.error_message)
                )
            }
    }

    private suspend fun getFavourites(id: Int) {
        _isFav.value = store.getFavouriteIds.first().contains(id)
        _favourites.value = store.getFavouriteIds.first()
    }

}