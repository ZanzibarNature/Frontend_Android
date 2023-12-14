package com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.calculator.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.kawatrainingcenter.zanzibarnature.R
import com.kawatrainingcenter.zanzibarnature.ui.components.button.DefaultBtn
import com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.calculator.model.Airport
import com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.calculator.model.Airports

@Composable
fun FlightForm(
    airports: Airports?,
    filterAirports: (String) -> Unit,
    onClick: (Airport, Airport, Int) -> Unit
) {
    var fromAirport by remember { mutableStateOf<Airport?>(null) }
    var toAirport by remember { mutableStateOf<Airport?>(null) }
    var tickets by remember { mutableIntStateOf(0) }

    Column(modifier = Modifier.padding(16.dp)) {

        FlightDropdown(
            airports = airports,
            type = "departing",
            onChange = { filterAirports(it) },
            onClick = { fromAirport = it }
        )

        Spacer(modifier = Modifier.padding(8.dp))

        FlightDropdown(
            airports = airports,
            type = "destination",
            onChange = { filterAirports(it) },
            onClick = { toAirport = it }
        )

        Spacer(modifier = Modifier.padding(8.dp))

        NumberField(
            label = stringResource(R.string.amount_of_tickets),
            onChange = { tickets = it }
        )

        DefaultBtn(
            onClick = { onClick(fromAirport!!, toAirport!!, tickets) },
            text = stringResource(R.string.calculate),
            enabled = fromAirport != null && toAirport != null && tickets > 0
        )
    }
}