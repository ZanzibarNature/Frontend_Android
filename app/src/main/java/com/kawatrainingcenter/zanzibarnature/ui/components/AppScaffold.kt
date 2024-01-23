package com.kawatrainingcenter.zanzibarnature.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface

//not material 3 because then unselected color doesn't work
import androidx.compose.material.Icon
import androidx.compose.material.Text

import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.kawatrainingcenter.zanzibarnature.R
import com.kawatrainingcenter.zanzibarnature.ui.navigation.NavigationType

sealed class Screen(
    val route: String,
    val label: String,
    val icon: Int
) {
    object Explore : Screen(
        "explore", "Explore",
        icon = R.drawable.outline_explore_24,
    )

    object Dashboard : Screen(
        "dashboard", "Dashboard",
        icon = R.drawable.baseline_space_dashboard_24,
    )

    object Contribute : Screen(
        "contribute", "Contribute",
        icon = R.drawable.baseline_handshake_24
    )

    object About : Screen(
        "about", "About",
        icon = R.drawable.kawalogoabstract
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppScaffold(
    title: String,
    navController: NavController,
    navigation: NavigationType? = null,
    actions: @Composable RowScope.() -> Unit = {},
    content: @Composable (PaddingValues) -> Unit
) {

    val screens = listOf(
        Screen.Explore,
        Screen.Dashboard,
        Screen.Contribute,
        Screen.About
    )

    Scaffold(
        topBar = {
            Surface(color = MaterialTheme.colorScheme.primary) {
                if (title != "") {
                    TopAppBar(
                        title = {
                            Text(
                                text = title,
                                color = MaterialTheme.colorScheme.onPrimary,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.SemiBold,
                                style = TextStyle(
                                    fontWeight = FontWeight(700),
                                    color = MaterialTheme.colorScheme.onPrimary,
                                    textAlign = TextAlign.Center,
                                )
                            )
                        },
                        actions = actions,
                        navigationIcon = {
                            AppScaffoldTopBarNavigation(navigation = navigation)
                        },
                        colors = TopAppBarDefaults.mediumTopAppBarColors(
                            containerColor = MaterialTheme.colorScheme.primary,
                            titleContentColor = MaterialTheme.colorScheme.onPrimary,
                            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                            actionIconContentColor = MaterialTheme.colorScheme.onPrimary
                        )
                    )
                }
            }
        },
        content = content,
        bottomBar = {
            BottomNavigation(
                backgroundColor = MaterialTheme.colorScheme.primary
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                screens.forEach { screen ->
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                painterResource(id = screen.icon),
                                contentDescription = screen.label,
                                modifier = Modifier.size(30.dp)
                            )
                        },
                        label = {
                            Text(
                                screen.label,
                                fontSize = 12.sp,
                            )
                        },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        unselectedContentColor = MaterialTheme.colorScheme.onPrimary.copy(0.6f),
                        selectedContentColor = MaterialTheme.colorScheme.onPrimary,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = false
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    )
}

@Composable
fun AppScaffoldTopBarNavigation(
    navigation: NavigationType?
) {
    when (navigation) {

        is NavigationType.Back -> {
            IconButton(navigation.onClick) {
                Icon(
                    painter = painterResource(R.drawable.baseline_arrow_circle_left_24),
                    contentDescription = stringResource(R.string.navigate_back_description),
                    tint = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.size(35.dp)
                )
            }
        }

        else -> { /* NO-OP */
        }
    }
}


