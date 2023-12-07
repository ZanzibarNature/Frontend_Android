package com.kawatrainingcenter.zanzibarnature.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.kawatrainingcenter.zanzibarnature.ui.pages.about.AboutPage
import com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.calculator.CalculatorPage
import com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.main.ContributePage
import com.kawatrainingcenter.zanzibarnature.ui.pages.dashboard.DashboardPage
import com.kawatrainingcenter.zanzibarnature.ui.pages.explore.explore_list.ExploreListPage

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "explore"
    ) {

        navigation(startDestination = "explore_list", route = "explore") {
            composable("explore_list") {
                ExploreListPage(navController = navController)
            }
        }

        composable("dashboard") {
            DashboardPage(navController = navController)
        }

        navigation(startDestination = "contribute_main", route = "contribute") {
            composable("contribute_main") {
                ContributePage(navController = navController)
            }
            composable("calculator") {
                CalculatorPage(navController = navController)
            }
        }

        navigation(startDestination = "about_main", route = "about") {
            composable("about_main") {
                AboutPage(navController = navController)
            }
        }
    }
}