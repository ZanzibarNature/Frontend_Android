package com.kawatrainingcenter.zanzibarnature.ui.pages.explore.explore_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import com.kawatrainingcenter.zanzibarnature.R
import com.kawatrainingcenter.zanzibarnature.ui.components.AppScaffold
import com.kawatrainingcenter.zanzibarnature.ui.components.button.DefaultBtn
import com.kawatrainingcenter.zanzibarnature.ui.components.states.ErrorMessage
import com.kawatrainingcenter.zanzibarnature.ui.components.states.LoadingIndicator
import com.kawatrainingcenter.zanzibarnature.ui.helper.LifeCycleHandler
import com.kawatrainingcenter.zanzibarnature.ui.pages.explore.component.MapListBtn
import com.kawatrainingcenter.zanzibarnature.ui.pages.explore.explore_list.component.LocationList
import com.kawatrainingcenter.zanzibarnature.ui.pages.explore.explore_list.state.LocationsState

@Composable
fun ExploreListPage(
    viewModel: ExploreListViewModel = hiltViewModel(),
    navController: NavController,
    onLocationClick: (Int) -> Unit
) {
    val locations by viewModel.locations.collectAsState()
    val favorites by viewModel.favourites.collectAsState()

    LifeCycleHandler { _, event ->
        when (event) {
            Lifecycle.Event.ON_RESUME -> {
                viewModel.reloadFavorites()
            }

            else -> {}
        }
    }

    AppScaffold(title = "", navController = navController) {
        Box(modifier = Modifier.padding(it)) {

            when (val state = locations) {
                LocationsState.Loading -> LoadingIndicator()

                is LocationsState.Success -> {
                    Box {
                        LocationList(
                            locations = state.locations,
                            onLocationClick = { id -> onLocationClick(id) },
                            favorites = favorites
                        )

                        Column(
                            modifier = Modifier
                                .align(Alignment.BottomCenter)
                                .padding(bottom = 16.dp)
                        ) {
                            MapListBtn(
                                onClick = { navController.navigate("explore_map") },
                                map = false
                            )
                        }
                    }
                }

                is LocationsState.Error -> ErrorMessage(message = state.message)
            }
        }
    }
}