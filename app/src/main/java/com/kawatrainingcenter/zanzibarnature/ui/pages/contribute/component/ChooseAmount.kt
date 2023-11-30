package com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun ChooseAmount() {
    var activeState by remember { mutableIntStateOf(0) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            listOf(1, 2, 5, 10).forEach { amount ->
                AmountButton(amount = amount, isActive = activeState == amount) {
                    activeState = amount
                }
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            listOf(20, 50).forEach { amount ->
                AmountButton(amount = amount, isActive = activeState == amount) {
                    activeState = amount
                }
            }

            EnterAmountBtn(id = 999, amount = 0, isActive = activeState == 999) {
                activeState = 999
            }
        }
    }
}