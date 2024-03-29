package com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.kawatrainingcenter.zanzibarnature.R
import com.kawatrainingcenter.zanzibarnature.ui.components.AppScaffold
import com.kawatrainingcenter.zanzibarnature.ui.components.button.DonateButton
import com.kawatrainingcenter.zanzibarnature.ui.components.states.ErrorDialog
import com.kawatrainingcenter.zanzibarnature.ui.components.states.LoadingIndicator
import com.kawatrainingcenter.zanzibarnature.ui.navigation.NavigationType
import com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.component.chooseAmount.BigAmountBtn
import com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.component.chooseAmount.ChooseAmount
import com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.donate.DonateViewModel
import com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.donate.component.ProjectTile
import com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.donate.state.ProjectState

@Composable
fun DonatePage(
    navController: NavController,
    viewModel: DonateViewModel = hiltViewModel()
) {
    val enteredAmount by viewModel.entered.collectAsState()
    val project by viewModel.project.collectAsState()

    val scrollState = rememberScrollState()

    AppScaffold(
        title = stringResource(R.string.contribute),
        navController = navController,
        navigation = NavigationType.Back { navController.popBackStack() }
    ) {

        Column(
            modifier = Modifier
                .padding(it)
                .verticalScroll(scrollState)
        ) {

            when (val state = project) {
                ProjectState.Loading -> LoadingIndicator()

                is ProjectState.Success -> {
                    ProjectTile(project = state.project)

                    ChooseAmount(
                        enteredAmount = enteredAmount,
                        onChange = { data -> viewModel.updateEntered(data) },
                    )

                    Column(
                        verticalArrangement = Arrangement.SpaceBetween,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        if (state.project.name == "Tree Planting") {
                            BigAmountBtn(
                                onClick = { navController.navigate("calculator") },
                                label = stringResource(R.string.calculate_co2),
                                isActive = false
                            )
                            Spacer(modifier = Modifier.padding(10.dp))

                        } else {
                            Spacer(modifier = Modifier.padding(55.dp))
                        }

                        DonateButton(amount = enteredAmount)
                    }
                }

                //On retry the page is loaded again
                is ProjectState.Error -> ErrorDialog(
                    message = state.message,
                    retry = { viewModel.loadPage() })
            }

        }
    }
}