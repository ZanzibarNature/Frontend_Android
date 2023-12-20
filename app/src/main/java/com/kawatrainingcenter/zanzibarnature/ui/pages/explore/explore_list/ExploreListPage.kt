package com.kawatrainingcenter.zanzibarnature.ui.pages.explore.explore_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.kawatrainingcenter.zanzibarnature.ui.components.AppScaffold
import com.kawatrainingcenter.zanzibarnature.ui.components.states.ErrorMessage
import com.kawatrainingcenter.zanzibarnature.ui.components.states.LoadingIndicator
import com.kawatrainingcenter.zanzibarnature.ui.pages.explore.explore_list.component.LocationList
import com.kawatrainingcenter.zanzibarnature.ui.pages.explore.explore_list.state.LocationsState

@Composable
fun ExploreListPage(
    viewModel: ExploreListViewModel = hiltViewModel(),
    navController: NavController,
    onLocationClick: (Int) -> Unit
) {

    val locations by viewModel.locations.collectAsState()

    AppScaffold(title = "Explore", navController = navController) {
        Box(modifier = Modifier.padding(it)) {

            when (val state = locations) {
                LocationsState.Loading -> LoadingIndicator()

                is LocationsState.Success -> {
                    LocationList(
                        locations = state.locations.locations,
                        onLocationClick = { id -> onLocationClick(id)}
                    )
                }

                is LocationsState.Error -> ErrorMessage(message = state.message)
            }
        }
    }
}