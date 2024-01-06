package com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.kawatrainingcenter.zanzibarnature.R
import com.kawatrainingcenter.zanzibarnature.ui.components.AppScaffold
import com.kawatrainingcenter.zanzibarnature.ui.components.states.ErrorMessage
import com.kawatrainingcenter.zanzibarnature.ui.components.states.LoadingIndicator
import com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.main.component.ProjectList
import com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.main.state.ProjectsState
import com.kawatrainingcenter.zanzibarnature.ui.pages.explore.explore_list.component.LocationList

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
                    Text(
                        text = stringResource(R.string.our_projects),
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight(700),
                            color = MaterialTheme.colorScheme.onBackground,
                        ),
                        modifier = Modifier.padding(12.dp)
                    )
                    Box(modifier = Modifier.padding(top = 44.dp)) {
                        ProjectList(
                            projects = state.projects,
                            onProjectClick = { name -> onProjectClick(name) }
                        )
                    }


                }

                is ProjectsState.Error -> ErrorMessage(message = state.message)
            }
        }
    }
}