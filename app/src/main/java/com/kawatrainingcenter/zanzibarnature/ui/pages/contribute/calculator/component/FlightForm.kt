package com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.calculator.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.kawatrainingcenter.zanzibarnature.R
import com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.calculator.model.Airports

@Composable
fun FlightForm(
    airports: Airports?,
    filterAirports: (String) -> Unit
) {

    Column(modifier = Modifier.padding(16.dp)) {

        FlightDropdown(
            airports = airports,
            type = "departing",
            onChange = { filterAirports(it) }
        )

        Spacer(modifier = Modifier.padding(8.dp))

        FlightDropdown(
            airports = airports,
            type = "destination",
            onChange = { filterAirports(it) }
        )

        Spacer(modifier = Modifier.padding(8.dp))

        NumberField(label = stringResource(R.string.amount_of_tickets))
    }
}