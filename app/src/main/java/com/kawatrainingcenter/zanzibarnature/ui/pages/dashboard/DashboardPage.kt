package com.kawatrainingcenter.zanzibarnature.ui.pages.dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import com.kawatrainingcenter.zanzibarnature.R
import com.kawatrainingcenter.zanzibarnature.ui.components.AppScaffold
import com.kawatrainingcenter.zanzibarnature.ui.components.states.ErrorMessage
import com.kawatrainingcenter.zanzibarnature.ui.components.states.LoadingIndicator
import com.kawatrainingcenter.zanzibarnature.ui.components.text.HeaderText
import com.kawatrainingcenter.zanzibarnature.ui.helper.LifeCycleHandler
import com.kawatrainingcenter.zanzibarnature.ui.pages.explore.explore_list.component.LocationList
import com.kawatrainingcenter.zanzibarnature.ui.pages.explore.explore_list.state.LocationsState

@Composable
fun DashboardPage(
    viewModel: DasboardViewModel = hiltViewModel(),
    navController: NavController,
    onLocationClick: (Int) -> Unit
) {
    val locations by viewModel.locations.collectAsState()

    LifeCycleHandler { _, event ->
        when (event) {
            Lifecycle.Event.ON_RESUME -> {
                viewModel.reloadFavourites()
            }

            else -> {}
        }
    }

    AppScaffold(title = stringResource(R.string.dashboard), navController = navController) {
        Box(modifier = Modifier.padding(it)) {

            when (val state = locations) {
                LocationsState.Loading -> LoadingIndicator()

                is LocationsState.Success -> {

                    Box {
                        LocationList(
                            locations = state.locations,
                            onLocationClick = { id -> onLocationClick(id) },
                            favorites = emptySet()
                        )
                    }

                    HeaderText(
                        stringResource(R.string.saved_locations),
                        PaddingValues(start = 12.dp, top = 12.dp)
                    )
                }

                is LocationsState.Error -> ErrorMessage(message = state.message)
            }
        }
    }
}