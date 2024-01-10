package com.kawatrainingcenter.zanzibarnature.ui.pages.explore.location_detail.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kawatrainingcenter.zanzibarnature.R

@Composable
fun SaveButton(
    isFavourite: Boolean,
    onClickFavourite: () -> Unit
) {
    Row {
        Text(
            modifier = Modifier.padding(4.dp),
            text = if (isFavourite) stringResource(R.string.saved) else stringResource(R.string.save),
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight(700),
                color = Color.White,
                shadow = Shadow(
                    color = Color.Black,
                    offset = Offset(2.0f, 5.0f),
                    blurRadius = 4f
                )
            )
        )
        Icon(
            painter = if (isFavourite) painterResource(R.drawable.favorite) else painterResource(
                R.drawable.favorite_border
            ),
            contentDescription = stringResource(R.string.Favourite_desc),
            tint = if (isFavourite) Color(0xFFF2411A) else Color.White,
            modifier = Modifier
                .width(35.dp)
                .height(35.dp)
                .clip(CircleShape)
                .clickable { onClickFavourite() }
        )
    }
}