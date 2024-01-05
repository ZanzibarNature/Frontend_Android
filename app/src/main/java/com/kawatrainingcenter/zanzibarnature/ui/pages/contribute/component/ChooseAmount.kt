package com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kawatrainingcenter.zanzibarnature.R

@Composable
fun ChooseAmount(
    compensation: Int = 0,
    enteredAmount: Int,
    onChange: (Int) -> Unit
) {
    var activeState by remember { mutableIntStateOf(0) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        if (compensation != 0) {
            BigAmountBtn(
                label = "${stringResource(R.string.currency_symbol)}$compensation ${
                    stringResource(
                        R.string.calculated
                    )
                }", isActive = activeState == compensation
            ) {
                activeState = compensation
                onChange(compensation)
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            listOf(1, 2, 5, 10).forEach { amount ->
                AmountButton(amount = amount, isActive = activeState == amount) {
                    activeState = amount
                    onChange(amount)
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            listOf(20, 50).forEach { amount ->
                AmountButton(amount = amount, isActive = activeState == amount) {
                    activeState = amount
                    onChange(amount)
                }
            }

            EnterAmountBtn(
                amount = enteredAmount,
                isActive = activeState == 999,
                onClick = { activeState = 999 },
                onChange = { data -> onChange(data) }
            )
        }
    }
}