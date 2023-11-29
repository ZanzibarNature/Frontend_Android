package com.kawatrainingcenter.zanzibarnature.ui.pages.explore_map

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.kawatrainingcenter.zanzibarnature.ui.components.AppScaffold

@Composable
fun ExploreMapPage(
    navController: NavController
) {
    AppScaffold(title = "Explore", navController = navController) {
        Text(text = "explore map page", modifier = Modifier.padding(it))
    }

}