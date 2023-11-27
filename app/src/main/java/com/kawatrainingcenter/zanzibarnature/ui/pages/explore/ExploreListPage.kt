package com.kawatrainingcenter.zanzibarnature.ui.pages.explore

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.kawatrainingcenter.zanzibarnature.ui.components.AppScaffold

@Composable
fun ExploreListPage(
    navController: NavController
) {
    AppScaffold(title = "Explore", navController = navController) {
        Text(text = "explore list page")
    }
}