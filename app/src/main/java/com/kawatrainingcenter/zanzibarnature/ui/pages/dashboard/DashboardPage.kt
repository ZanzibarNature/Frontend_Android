package com.kawatrainingcenter.zanzibarnature.ui.pages.dashboard

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.kawatrainingcenter.zanzibarnature.ui.components.AppScaffold

@Composable
fun DashboardPage(
    navController: NavController
) {
    AppScaffold(title = "Dashboard", navController = navController) {
        Text(text = "Dashboard page")
    }
}