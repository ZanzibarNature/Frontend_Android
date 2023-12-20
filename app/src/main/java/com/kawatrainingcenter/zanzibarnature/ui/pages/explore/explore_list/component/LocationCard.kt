package com.kawatrainingcenter.zanzibarnature.ui.pages.explore.explore_list.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.model.Location


@Composable
fun LocationCard(
    location: Location
) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(130.dp),
        shape = RoundedCornerShape(5.dp),
    ) {
        Row {
            AsyncImage(
                model = location.images[0],
                modifier = Modifier
                    .fillMaxHeight()
                    .width(140.dp),
                //painter = painterResource(R.drawable.beach),
                contentScale = ContentScale.Crop,
                contentDescription = "")
            Column {
                Text(
                    modifier = Modifier.padding(start = 8.dp, top = 4.dp),
                    text = location.title,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight(700),
                        color = MaterialTheme.colorScheme.onBackground,
                        )
                )

                Text(
                    modifier = Modifier.padding(start = 8.dp),
                    text = location.description,
                    maxLines = 5,
                    overflow = TextOverflow.Ellipsis,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(400),
                        color = MaterialTheme.colorScheme.onBackground,
                        )
                )
            }
        }
    }
}