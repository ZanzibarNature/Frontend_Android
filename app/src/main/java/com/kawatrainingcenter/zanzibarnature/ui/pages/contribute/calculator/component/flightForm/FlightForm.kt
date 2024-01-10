package com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.calculator.component.flightForm

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kawatrainingcenter.zanzibarnature.R
import com.kawatrainingcenter.zanzibarnature.ui.components.button.DefaultBtn
import com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.calculator.model.Airport
import com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.calculator.model.Airports

@Composable
fun FlightForm(
    airports: Airports?,
    filterAirports: (String) -> Unit,
    onClick: (Airport, Airport, Int, Boolean) -> Unit
) {
    var fromAirport by remember { mutableStateOf<Airport?>(null) }
    var toAirport by remember { mutableStateOf<Airport?>(null) }
    var tickets by remember { mutableIntStateOf(0) }
    var oneway by remember { mutableStateOf(true) }

    Column(modifier = Modifier.padding(0.dp)) {

        FlightDropdown(
            airports = airports,
            type = stringResource(R.string.departing),
            onChange = { filterAirports(it) },
            onClick = { fromAirport = it }
        )

        Spacer(modifier = Modifier.padding(8.dp))

        FlightDropdown(
            airports = airports,
            type = stringResource(R.string.destination),
            onChange = { filterAirports(it) },
            onClick = { toAirport = it }
        )

        Row(modifier = Modifier.padding(start = 4.dp, end = 8.dp)) {
            Checkbox(
                checked = !oneway,
                onCheckedChange = { oneway = !oneway },
                colors = CheckboxDefaults.colors(checkedColor = MaterialTheme.colorScheme.primary)
            )
            Text(
                text = stringResource(R.string.return_flight),
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight(400),
                    color = MaterialTheme.colorScheme.onBackground,
                ),
                modifier = Modifier.padding(top = 11.dp)
            )
        }

        Spacer(modifier = Modifier.padding(4.dp))

        NumberField(
            label = stringResource(R.string.amount_of_tickets),
            onChange = { tickets = it }
        )

        Spacer(modifier = Modifier.padding(50.dp))

        DefaultBtn(
            onClick = { onClick(fromAirport!!, toAirport!!, tickets, oneway) },
            text = stringResource(R.string.calculate),
            enabled = fromAirport != null && toAirport != null && tickets > 0
        )
    }
}