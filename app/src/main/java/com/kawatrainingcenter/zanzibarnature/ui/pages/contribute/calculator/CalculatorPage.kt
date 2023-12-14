package com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.calculator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
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
import com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.calculator.component.FlightForm
import com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.calculator.model.Airport
import com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.calculator.model.CompensationState
import com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.component.ChooseAmount
import kotlin.math.roundToInt

@Composable
fun CalculatorPage(
    navController: NavController,
    viewModel: CalculatorViewModel = hiltViewModel()
) {
    val uriHandler = LocalUriHandler.current
    val state by viewModel.state.collectAsState()
    val airports by viewModel.airportState.collectAsState()

    val enteredAmount by viewModel.entered.collectAsState()

    AppScaffold(
        title = "Contribute",
        navController = navController,
        navigation = NavigationType.Back { navController.popBackStack() }
    ) {
        Column(modifier = Modifier.padding(it), verticalArrangement = Arrangement.SpaceBetween) {

            Row (horizontalArrangement = Arrangement.SpaceBetween) {
                Text(
                    text = stringResource(R.string.co2_calculator),
                    fontSize = 24.sp,
                    fontWeight = FontWeight(800),
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.padding(16.dp)
                ) 
                
                Spacer(modifier = Modifier.padding(horizontal = 60.dp))
                
                Icon(
                    painter = painterResource(id = R.drawable.baseline_airplanemode_active_24),
                    contentDescription = "",
                    tint = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier
                        .padding(end = 12.dp, top = 4.dp)
                        .size(65.dp)
                        .rotate(degrees = 45f)
                        .alpha(0.3f)
                )
            }

            when (val state = state) {
                CompensationState.NotClicked -> {
                    FlightForm(
                        airports = airports,
                        filterAirports = { string -> viewModel.filterAirports(string) },
                        onClick = { airportFrom: Airport, airportTo: Airport, tickets: Int ->  viewModel.getCompensation(airportFrom, airportTo, tickets)}
                    )
                }
                CompensationState.Loading -> LoadingIndicator()

                is CompensationState.Success -> {
                    ChooseAmount(
                        compensation = state.compensation.total.roundToInt(),
                        enteredAmount = enteredAmount,
                        onChange = { data -> viewModel.updateEntered(data) }
                    )

                    DefaultBtn(onClick = { uriHandler.openUri("https://www.paypal.com/donate?token=-DWIqPILgSa-E_sf6a_0Of6mlyzPOP0_bczmXNt2GMBlEjZit0zo0XYeYXzmyGiVhgpiBM6VVv4PY0Rg") }, text = stringResource(R.string.donate))
                }

                is CompensationState.Error -> ErrorMessage(message = state.message)
            }
        }
    }
}