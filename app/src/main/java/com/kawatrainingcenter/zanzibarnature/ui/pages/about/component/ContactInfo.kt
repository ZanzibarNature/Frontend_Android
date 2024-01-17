package com.kawatrainingcenter.zanzibarnature.ui.pages.about.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.kawatrainingcenter.zanzibarnature.ui.components.text.ParagraphText

@Composable
fun ContactInfo(
    modifier: Modifier = Modifier,
    icon: Int,
    info: String,

) {
    Row(modifier = modifier) {
        Image(
            painter = painterResource(icon),
            contentDescription = "",
            contentScale = ContentScale.None
        )

        ParagraphText(text = info, padding = PaddingValues(start = 4.dp))
    }
}