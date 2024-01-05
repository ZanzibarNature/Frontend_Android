package com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.kawatrainingcenter.zanzibarnature.ui.components.AppScaffold
import com.kawatrainingcenter.zanzibarnature.ui.components.states.ErrorMessage
import com.kawatrainingcenter.zanzibarnature.ui.components.states.LoadingIndicator
import com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.main.component.ProjectList
import com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.main.state.ProjectsState

@Composable
fun ContributePage(
    navController: NavController,
    viewModel: ContributeViewModel = hiltViewModel(),
    onProjectClick: (String) -> Unit
) {
    val projects by viewModel.projects.collectAsState()

    AppScaffold(title = "Contribute", navController = navController) {
        Box(modifier = Modifier.padding(it)) {
            when (val state = projects) {
                ProjectsState.Loading -> LoadingIndicator()

                is ProjectsState.Success -> {
                    ProjectList(
                        projects = state.projects,
                        onProjectClick = { name -> onProjectClick(name) }
                    )
                }

                is ProjectsState.Error -> ErrorMessage(message = state.message)
            }
        }
    }
}