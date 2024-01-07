package com.kawatrainingcenter.zanzibarnature.ui.pages.explore.explore_list.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kawatrainingcenter.zanzibarnature.ui.helper.IconType
import com.kawatrainingcenter.zanzibarnature.ui.helper.customShadow

@Composable
fun SortingBubble(
    type: String,
    iconName: String,
    isClicked: Boolean,
    onClick: () -> Unit
) {
    val icons = listOf(
        IconType.Hiking,
        IconType.Swim,
        IconType.Monkey,
        IconType.Tour,
        IconType.Kawa
    )

    Button(
        onClick = onClick,
        contentPadding = PaddingValues(start = 8.dp, end = 8.dp),
        colors = ButtonDefaults.buttonColors(
            if (isClicked) Color.White else MaterialTheme.colorScheme.secondary
        ),
        shape = RoundedCornerShape(size = 20.dp),
        modifier = Modifier
//            .shadow(
//                elevation = 4.dp,
//                spotColor = Color(0x80000000),
//                ambientColor = Color(0x80000000),
//                shape = RoundedCornerShape(size = 20.dp),
//            )
            .height(45.dp)
            .padding(4.dp)
            .wrapContentWidth()
            .customShadow(
                color = Color.Black.copy(0.8f),
                borderRadius = 20.dp,
                blurRadius = 4.dp,
                offsetX = 0.dp,
                offsetY = 6.dp,
                spread = (-4).dp
            )

    )
    {
        Text(
            text = type.capitalize(),
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = if (isClicked) FontWeight(700) else FontWeight(500),
                color = MaterialTheme.colorScheme.primary,
            )
        )

        Spacer(modifier = Modifier.padding(2.dp))
        icons.forEach { icon ->
            if (icon.name == iconName) {
                Icon(
                    painter = painterResource(id = icon.icon),
                    contentDescription = icon.name,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .height(25.dp)
                        .width(25.dp)
                )
            }
        }

    }
}