package com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.kawatrainingcenter.zanzibarnature.R
import com.kawatrainingcenter.zanzibarnature.ui.components.AppScaffold
import com.kawatrainingcenter.zanzibarnature.ui.components.states.ErrorDialog
import com.kawatrainingcenter.zanzibarnature.ui.components.states.LoadingIndicator
import com.kawatrainingcenter.zanzibarnature.ui.components.text.HeaderText
import com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.main.component.ProjectList
import com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.main.state.ProjectsState

@Composable
fun ContributePage(
    navController: NavController,
    viewModel: ContributeViewModel = hiltViewModel(),
    onProjectClick: (String) -> Unit
) {
    val projects by viewModel.projects.collectAsState()

    AppScaffold(title = stringResource(R.string.contribute), navController = navController)
    {
        Box(
            modifier = Modifier
                .padding(it)
        ) {
            when (val state = projects) {
                ProjectsState.Loading -> LoadingIndicator()

                is ProjectsState.Success -> {

                    Box {
                        ProjectList(
                            projects = state.projects,
                            onProjectClick = { id -> onProjectClick(id) }
                        )
                    }

                    HeaderText(
                        stringResource(R.string.our_projects),
                        PaddingValues(12.dp)
                    )
                }

                is ProjectsState.Error -> ErrorDialog(
                    message = state.message,
                    retry = { viewModel.loadPage() })
            }
        }
    }
}