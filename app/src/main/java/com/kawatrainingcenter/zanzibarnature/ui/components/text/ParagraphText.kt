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
fun ParagraphText(
    modifier: Modifier = Modifier,
    text: String,
    padding: PaddingValues = PaddingValues(0.dp)
) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight(400),
            color = MaterialTheme.colorScheme.onBackground,
        ),
        modifier = modifier.padding(padding)
    )
}