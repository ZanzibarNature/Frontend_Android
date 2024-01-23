package com.kawatrainingcenter.zanzibarnature.ui.pages.explore.location_detail.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kawatrainingcenter.zanzibarnature.R
import com.kawatrainingcenter.zanzibarnature.ui.helper.customShadow

//A special highlighted section displaying Kawa's involvement, with a button that navigates to the contribute page
@Composable
fun KawaDescription(
    description: String,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(MaterialTheme.colorScheme.tertiary.copy(0.25f))
            .wrapContentSize()
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.kawalogoabstract),
                contentDescription = "",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .padding(start = 8.dp, top = 8.dp)
                    .width(36.dp)
                    .height(27.dp)

            )
            Text(
                text = stringResource(R.string.kawa),
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight(700),
                    color = MaterialTheme.colorScheme.onTertiary,
                ),
                modifier = Modifier.padding(start = 8.dp, top = 8.dp, end = 40.dp)
            )
            
            Spacer(modifier = Modifier.padding(10.dp))

            Button(
                onClick = onClick,
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiary),
                contentPadding = PaddingValues(0.dp),
                modifier = Modifier
                    .width(210.dp)
                    .height(40.dp)
                    .padding(0.dp)
                    .customShadow(
                        color = Color.Black.copy(0.4f),
                        borderRadius = 5.dp,
                        blurRadius = 6.dp,
                        offsetX = 2.dp,
                        offsetY = 8.dp,
                        spread = 0.dp
                    )
            )
            {
                Text(
                    text = stringResource(R.string.contribute_want),
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight(400),
                        color = MaterialTheme.colorScheme.onTertiary,
                    ),
                    modifier = Modifier.padding(end = 4.dp)
                )

                Image(
                    painter = painterResource(id = R.drawable.baseline_handshake_24),
                    contentDescription = "",
                    contentScale = ContentScale.None,
                    modifier = Modifier
                        .width(30.dp)
                        .height(30.dp)
                )
            }
        }
        Box(modifier = Modifier.padding(12.dp)) {
            Text(text = description)
        }
    }
}