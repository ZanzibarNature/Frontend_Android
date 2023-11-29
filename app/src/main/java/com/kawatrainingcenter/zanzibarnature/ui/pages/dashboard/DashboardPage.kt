package com.kawatrainingcenter.zanzibarnature.ui.pages.dashboard

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.kawatrainingcenter.zanzibarnature.ui.components.AppScaffold

@Composable
fun DashboardPage(
    navController: NavController
) {
    AppScaffold(title = "Dashboard", navController = navController) {
        Text(text = "Dashboard page", modifier = Modifier.padding(it))
    }
}