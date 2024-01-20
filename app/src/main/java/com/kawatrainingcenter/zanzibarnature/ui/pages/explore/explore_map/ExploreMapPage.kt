package com.kawatrainingcenter.zanzibarnature.ui.pages.explore.explore_map

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.kawatrainingcenter.zanzibarnature.ui.components.AppScaffold
import com.kawatrainingcenter.zanzibarnature.ui.components.states.ErrorDialog
import com.kawatrainingcenter.zanzibarnature.ui.components.states.LoadingIndicator
import com.kawatrainingcenter.zanzibarnature.ui.pages.explore.component.MapListBtn
import com.kawatrainingcenter.zanzibarnature.ui.pages.explore.explore_list.ExploreViewModel
import com.kawatrainingcenter.zanzibarnature.ui.pages.explore.explore_list.component.SortingBubbleList
import com.kawatrainingcenter.zanzibarnature.ui.pages.explore.explore_list.state.LocationsState
import com.kawatrainingcenter.zanzibarnature.ui.pages.explore.explore_map.component.OpenStreetMap

@Composable
fun ExploreMapPage(
    viewModel: ExploreViewModel = hiltViewModel(),
    navController: NavController,
    onLocationClick: (String) -> Unit
) {
    val locations by viewModel.locations.collectAsState()

    AppScaffold(title = "", navController = navController) {
        Box(modifier = Modifier.padding(it)) {
            when (val state = locations) {
                LocationsState.Loading -> LoadingIndicator()

                is LocationsState.Success -> {
                    Box {
                        OpenStreetMap(
                            locations = state.locations,
                            onClick = { id -> onLocationClick(id) })

                        Column(
                            modifier = Modifier
                                .align(Alignment.TopCenter)
                                .padding(bottom = 16.dp)
                        ) {
                            SortingBubbleList(onClick = { sortType ->
                                viewModel.filterLocations(
                                    sortType
                                )
                            })
                        }

                        Column(
                            modifier = Modifier
                                .align(Alignment.BottomCenter)
                                .padding(bottom = 16.dp)
                        ) {
                            MapListBtn(
                                onClick = { navController.navigate("explore_list") },
                                map = true
                            )
                        }
                    }
                }

                is LocationsState.Error -> ErrorDialog(
                    message = state.message,
                    retry = { viewModel.loadPage() }
                )
            }
        }
    }
}