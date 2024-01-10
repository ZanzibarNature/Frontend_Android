package com.kawatrainingcenter.zanzibarnature.ui.components.text

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun BigHeaderText(
    text: String,
    padding: PaddingValues
) {
    Text(
        text = text,
        fontSize = 26.sp,
        fontWeight = FontWeight(800),
        color = MaterialTheme.colorScheme.onBackground,
        modifier = Modifier.padding(padding)
    )
}