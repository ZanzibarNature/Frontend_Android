package com.kawatrainingcenter.zanzibarnature.ui.components.text

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SmallHeaderText(
    text: String,
    padding: PaddingValues = PaddingValues(0.dp)
) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = 17.sp,
            fontWeight = FontWeight(700),
            color = MaterialTheme.colorScheme.onBackground,
        ),
        modifier = Modifier.padding(padding)
    )
}