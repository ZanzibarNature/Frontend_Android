package com.kawatrainingcenter.zanzibarnature.ui.pages.explore_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.kawatrainingcenter.zanzibarnature.ui.components.AppScaffold
import com.kawatrainingcenter.zanzibarnature.ui.pages.explore_list.component.LocationList

@Composable
fun ExploreListPage(
    viewModel: ExploreListViewModel = hiltViewModel(),
    navController: NavController
) {
    AppScaffold(title = "Explore", navController = navController) {
        Box(modifier = Modifier.padding(it)) {
           LocationList(locations = viewModel.locations)
        }
    }
}