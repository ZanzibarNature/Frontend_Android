package com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.calculator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.text.TextStyle
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
import java.text.NumberFormat
import java.util.Locale
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

    val scrollState = rememberScrollState()

    fun formatNumber(number: Int): String {
        val format = NumberFormat.getNumberInstance(Locale.GERMANY)
        return format.format(number)
    }

    AppScaffold(
        title = stringResource(R.string.contribute),
        navController = navController,
        navigation = NavigationType.Back { navController.popBackStack() }
    ) {
        Column(modifier = Modifier
            .padding(it)
            .verticalScroll(scrollState), verticalArrangement = Arrangement.SpaceBetween) {

            Row (horizontalArrangement = Arrangement.SpaceBetween) {
                Text(
                    text = stringResource(R.string.co2_calculator),
                    fontSize = 26.sp,
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
                    Column {
                        Text(
                            text = stringResource(R.string.calculator_explanation),
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight(400),
                                color = MaterialTheme.colorScheme.onBackground
                            ),
                            modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                        )

                        FlightForm(
                            airports = airports,
                            filterAirports = { string -> viewModel.filterAirports(string) },
                            onClick = { airportFrom: Airport, airportTo: Airport, tickets: Int, oneway: Boolean ->  viewModel.getCompensation(airportFrom, airportTo, tickets, oneway)}
                        )
                    }
                }
                CompensationState.Loading -> LoadingIndicator()

                is CompensationState.Success -> {
                    Column {
                        Text(
                            text = "${stringResource(R.string.calculated_amount)} ${stringResource(R.string.currency_symbol)}${state.compensation.total.roundToInt()}",
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontWeight = FontWeight(600),
                                color = MaterialTheme.colorScheme.onBackground
                            ),
                            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 2.dp, bottom = 2.dp)
                        )
                        Text(
                            text = stringResource(R.string.calculated_donation_explained),
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight(400),
                                color = MaterialTheme.colorScheme.onBackground
                            ),
                            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 2.dp, bottom = 2.dp)
                        )

                        Text(
                            text = stringResource(R.string.choose_amount),
                            style = TextStyle(
                                fontSize = 22.sp,
                                fontWeight = FontWeight(700),
                                color = MaterialTheme.colorScheme.onBackground,
                                ),
                            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 2.dp)
                        )

                        ChooseAmount(
                            compensation = state.compensation.total.roundToInt(),
                            enteredAmount = enteredAmount,
                            onChange = { data -> viewModel.updateEntered(data) }
                        )
                        
                        Spacer(modifier = Modifier.padding(55.dp))

                        DefaultBtn(
                            onClick = { uriHandler.openUri("https://www.paypal.com/donate?token=-DWIqPILgSa-E_sf6a_0Of6mlyzPOP0_bczmXNt2GMBlEjZit0zo0XYeYXzmyGiVhgpiBM6VVv4PY0Rg")},
                            enabled = enteredAmount != 0,
                            text =
                            if(enteredAmount != 0) "${stringResource(R.string.donate)} ${stringResource(R.string.currency_symbol)}${formatNumber(enteredAmount)}"
                            else stringResource(R.string.donate)
                        )
                    }

                }

                is CompensationState.Error -> ErrorMessage(message = state.message)
            }
        }
    }
}