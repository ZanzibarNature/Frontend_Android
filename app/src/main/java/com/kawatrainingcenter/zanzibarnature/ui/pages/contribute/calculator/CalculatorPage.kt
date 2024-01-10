package com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.calculator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
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
import com.kawatrainingcenter.zanzibarnature.ui.components.button.DonateButton
import com.kawatrainingcenter.zanzibarnature.ui.components.states.ErrorMessage
import com.kawatrainingcenter.zanzibarnature.ui.components.states.LoadingIndicator
import com.kawatrainingcenter.zanzibarnature.ui.components.text.HeaderText
import com.kawatrainingcenter.zanzibarnature.ui.components.text.ParagraphText
import com.kawatrainingcenter.zanzibarnature.ui.navigation.NavigationType
import com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.calculator.component.CalculatorHeader
import com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.calculator.component.flightForm.FlightForm
import com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.calculator.model.Airport
import com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.calculator.model.CompensationState
import com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.component.chooseAmount.ChooseAmount
import java.text.NumberFormat
import java.util.Locale
import kotlin.math.roundToInt

@Composable
fun CalculatorPage(
    navController: NavController,
    viewModel: CalculatorViewModel = hiltViewModel()
) {
    val scrollState = rememberScrollState()

    val state by viewModel.state.collectAsState()
    val airports by viewModel.airportState.collectAsState()
    val enteredAmount by viewModel.entered.collectAsState()

    AppScaffold(
        title = stringResource(R.string.contribute),
        navController = navController,
        navigation = NavigationType.Back { navController.popBackStack() }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .verticalScroll(scrollState), verticalArrangement = Arrangement.SpaceBetween
        ) {

            CalculatorHeader()

            when (val state = state) {
                //This shows the flight form
                CompensationState.NotClicked -> {
                    Column {
                        ParagraphText(
                            stringResource(R.string.calculator_explanation),
                            PaddingValues(start = 16.dp, end = 16.dp, bottom = 16.dp)
                        )

                        FlightForm(
                            airports = airports,
                            filterAirports = { string -> viewModel.filterAirports(string) },
                            onClick = { airportFrom: Airport, airportTo: Airport, tickets: Int, oneway: Boolean ->
                                viewModel.getCompensation(airportFrom, airportTo, tickets, oneway)
                            }
                        )
                    }
                }

                //When the 'calculate' button is clicked a loading screen is presented
                CompensationState.Loading -> LoadingIndicator()

                //After loading the calculated amount is shown and the user can choose a different amount as well
                is CompensationState.Success -> {
                    Column {
                        HeaderText(
                            "${stringResource(R.string.calculated_amount)} ${stringResource(R.string.currency_symbol)}${state.compensation.total.roundToInt()}",
                            PaddingValues(start = 16.dp, end = 16.dp, top = 2.dp, bottom = 2.dp)
                        )

                        ParagraphText(
                            stringResource(R.string.calculated_donation_explained),
                            PaddingValues(start = 16.dp, end = 16.dp, top = 2.dp, bottom = 2.dp)
                        )

                        ChooseAmount(
                            compensation = state.compensation.total.roundToInt(),
                            enteredAmount = enteredAmount,
                            onChange = { data -> viewModel.updateEntered(data) }
                        )

                        Spacer(modifier = Modifier.padding(55.dp))

                        DonateButton(amount = enteredAmount)
                    }
                }

                is CompensationState.Error -> ErrorMessage(message = state.message)
            }
        }
    }
}