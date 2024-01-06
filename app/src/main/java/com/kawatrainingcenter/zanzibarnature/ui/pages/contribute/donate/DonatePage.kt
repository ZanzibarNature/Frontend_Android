package com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.kawatrainingcenter.zanzibarnature.R
import com.kawatrainingcenter.zanzibarnature.ui.components.AppScaffold
import com.kawatrainingcenter.zanzibarnature.ui.components.button.DefaultBtn
import com.kawatrainingcenter.zanzibarnature.ui.components.states.ErrorMessage
import com.kawatrainingcenter.zanzibarnature.ui.components.states.LoadingIndicator
import com.kawatrainingcenter.zanzibarnature.ui.navigation.NavigationType
import com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.component.BigAmountBtn
import com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.component.ChooseAmount
import com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.donate.DonateViewModel
import com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.donate.component.ProjectTile
import com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.donate.state.ProjectState
import com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.donate.state.ProjectStateMapper

@Composable
fun DonatePage(
    navController: NavController,
    viewModel: DonateViewModel = hiltViewModel()
) {
    val uriHandler = LocalUriHandler.current

    val enteredAmount by viewModel.entered.collectAsState()
    val project by viewModel.project.collectAsState()

    val scrollState = rememberScrollState()

    AppScaffold(
        title = "Contribute",
        navController = navController,
        navigation = NavigationType.Back { navController.popBackStack() }
    ) {

        Column(modifier = Modifier.padding(it).verticalScroll(scrollState)) {

            when (val state = project) {
                ProjectState.Loading -> LoadingIndicator()

                is ProjectState.Success -> {
                    ProjectTile(project = state.project)

                    Text(
                        text = "Donate",
                        fontSize = 20.sp,
                        fontWeight = FontWeight(700),
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier.padding(start = 12.dp, end = 12.dp, top = 8.dp)
                    )

                    Column(
                        verticalArrangement = Arrangement.SpaceBetween,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        ChooseAmount(
                            enteredAmount = enteredAmount,
                            onChange = { data -> viewModel.updateEntered(data) }
                        )

                        if(state.project.name == "Tree Planting") {
                            BigAmountBtn(
                                onClick = { navController.navigate("calculator") },
                                label = stringResource(R.string.calculate_co2),
                                isActive = false
                            )
                        }

                        //Spacer(modifier = Modifier.padding(50.dp))

                        DefaultBtn(
                            onClick = { uriHandler.openUri("https://www.paypal.com/donate?token=-DWIqPILgSa-E_sf6a_0Of6mlyzPOP0_bczmXNt2GMBlEjZit0zo0XYeYXzmyGiVhgpiBM6VVv4PY0Rg")},
                            enabled = enteredAmount != 0,
                            text =
                            if(enteredAmount != 0) "${stringResource(R.string.donate)} ${stringResource(R.string.currency_symbol)}$enteredAmount"
                            else stringResource(R.string.donate)
                        )
                    }
                }

                is ProjectState.Error -> ErrorMessage(message = state.message)
            }

        }
    }
}