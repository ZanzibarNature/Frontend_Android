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
import com.kawatrainingcenter.zanzibarnature.ui.helper.TouristActivities
import com.kawatrainingcenter.zanzibarnature.ui.helper.customShadow

@Composable
fun SortingBubble(
    type: String,
    iconName: String,
    isClicked: Boolean,
    onClick: () -> Unit
) {
    val activities = TouristActivities()

    Button(
        onClick = onClick,
        contentPadding = PaddingValues(start = 10.dp, end = 10.dp),
        colors = ButtonDefaults.buttonColors(
            if (isClicked) Color.White else MaterialTheme.colorScheme.secondary
        ),
        shape = RoundedCornerShape(size = 20.dp),
        modifier = Modifier
            .height(45.dp)
            .padding(4.dp)
            .wrapContentWidth()
            .customShadow(
                color = if(isClicked) Color.Transparent else Color.Black.copy(0.5f),
                borderRadius = 15.dp,
                blurRadius = 2.dp,
                offsetX = 0.dp,
                offsetY = 5.5.dp,
                spread = (-2).dp
            )

    )
    {
        Text(
            text = type.capitalize(),
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = if (isClicked) FontWeight(700) else FontWeight(500),
                color = MaterialTheme.colorScheme.onSecondary,
            )
        )

        Spacer(modifier = Modifier.padding(2.dp))
        activities.icons.forEach { icon ->
            if (icon.name == iconName) {
                Icon(
                    painter = painterResource(id = icon.icon),
                    contentDescription = icon.name,
                    tint = MaterialTheme.colorScheme.onSecondary,
                    modifier = Modifier
                        .height(25.dp)
                        .width(25.dp)
                )
            }
        }

    }
}