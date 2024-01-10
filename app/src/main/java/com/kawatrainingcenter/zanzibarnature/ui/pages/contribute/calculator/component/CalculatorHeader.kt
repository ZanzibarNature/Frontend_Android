package com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.calculator.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.kawatrainingcenter.zanzibarnature.R
import com.kawatrainingcenter.zanzibarnature.ui.components.text.BigHeaderText

@Composable
fun CalculatorHeader() {
    Row(horizontalArrangement = Arrangement.SpaceBetween) {
        BigHeaderText(
            stringResource(R.string.co2_calculator),
            PaddingValues(16.dp)
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
}