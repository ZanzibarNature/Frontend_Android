package com.kawatrainingcenter.zanzibarnature.ui.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.kawatrainingcenter.zanzibarnature.ui.pages.about.AboutPage
import com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.calculator.CalculatorPage
import com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.main.ContributePage
import com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.main.DonatePage
import com.kawatrainingcenter.zanzibarnature.ui.pages.dashboard.DashboardPage
import com.kawatrainingcenter.zanzibarnature.ui.pages.explore.explore_list.ExploreListPage
import com.kawatrainingcenter.zanzibarnature.ui.pages.explore.explore_map.ExploreMapPage
import com.kawatrainingcenter.zanzibarnature.ui.pages.explore.location_detail.LocationDetailPage

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "explore",
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None }
    ) {

        navigation(startDestination = "explore_list", route = "explore") {
            composable("explore_list") {
                ExploreListPage(
                    navController = navController,
                    onLocationClick = { navController.navigate("location_detail/${it}") }
                )
            }

            composable("explore_map") {
                ExploreMapPage(
                    navController = navController,
                    onLocationClick = { navController.navigate("location_detail/${it}") }
                )
            }

            composable(
                route = "location_detail/{location_id}",
                arguments = listOf(
                    navArgument("location_id") { type = NavType.StringType }
                ),
            ) {
                LocationDetailPage(
                    navController = navController
                )
            }
        }

        composable("dashboard") {
            DashboardPage(
                navController = navController,
                onLocationClick = { navController.navigate("location_detail/${it}") }
            )
        }

        navigation(startDestination = "contribute_main", route = "contribute") {
            composable("contribute_main") {
                ContributePage(
                    navController = navController,
                    onProjectClick = { navController.navigate("donate/${it}")}
                )
            }

            composable(
                route = "donate/{project_name}",
                arguments = listOf(
                    navArgument("project_name") { type = NavType.StringType }
                )
            ) {
                DonatePage(navController = navController)
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