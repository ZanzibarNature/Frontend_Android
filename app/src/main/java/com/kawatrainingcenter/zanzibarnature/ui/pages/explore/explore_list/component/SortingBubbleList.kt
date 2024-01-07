package com.kawatrainingcenter.zanzibarnature.ui.pages.explore.explore_list.component

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.kawatrainingcenter.zanzibarnature.ui.helper.IconType

@Composable
fun SortingBubbleList(
    onClick: (String) -> Unit
) {
    val scrollState = rememberScrollState()
    var isClicked by remember { mutableStateOf("") }

    val icons = listOf(
        IconType.Hiking,
        IconType.Swim,
        IconType.Monkey,
        IconType.Tour,
        IconType.Kawa
    )

    Row(
        modifier = Modifier
            .padding(top = 8.dp, start = 8.dp)
            .fillMaxWidth()
            .horizontalScroll(scrollState)
            .background(Color.Transparent)
    ) {
        icons.forEach() { icon ->
            SortingBubble(
                type = icon.name,
                iconName = icon.name,
                isClicked = (icon.name == isClicked),
                onClick = {
                    isClicked = if (isClicked == icon.name) "" else icon.name
                    onClick(isClicked)
                })
        }
    }
}