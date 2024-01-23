package com.kawatrainingcenter.zanzibarnature.ui.pages.explore.location_detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.kawatrainingcenter.zanzibarnature.R
import com.kawatrainingcenter.zanzibarnature.ui.components.AppScaffold
import com.kawatrainingcenter.zanzibarnature.ui.components.states.ErrorDialog
import com.kawatrainingcenter.zanzibarnature.ui.components.states.LoadingIndicator
import com.kawatrainingcenter.zanzibarnature.ui.navigation.NavigationType
import com.kawatrainingcenter.zanzibarnature.ui.pages.explore.location_detail.component.LocationDetail
import com.kawatrainingcenter.zanzibarnature.ui.pages.explore.location_detail.state.LocationState


@Composable
fun LocationDetailPage(
    viewModel: LocationDetailViewModel = hiltViewModel(),
    navController: NavController
) {

    val location by viewModel.location.collectAsState()
    val isFav by viewModel.isFav.collectAsState()

    AppScaffold(
        title = stringResource(R.string.location),
        navController = navController,
        navigation = NavigationType.Back { navController.popBackStack() }
    ) {
        Column(modifier = Modifier.padding(it)) {

            when(val state = location) {
                LocationState.Loading -> LoadingIndicator()

                is LocationState.Success -> {
                   LocationDetail(
                       location = state.location,
                       isFavourite = isFav,
                       onClickFavourite = {
                           viewModel.addToFavourite(state.location.id)
                       },
                       navigateToContribute = { navController.navigate("contribute") }
                   )

                }

                //On retry the page is loaded again
                is LocationState.Error -> ErrorDialog(
                    message = state.message,
                    retry = { viewModel.loadPage() }
                )
            }
        }
    }
}