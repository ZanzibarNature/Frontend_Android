package com.kawatrainingcenter.zanzibarnature.ui.pages.explore.explore_list.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.kawatrainingcenter.zanzibarnature.R
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.model.Location
import com.kawatrainingcenter.zanzibarnature.ui.helper.TouristActivities
import com.kawatrainingcenter.zanzibarnature.ui.helper.customShadow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LocationCard(
    location: Location,
    onClick: () -> Unit,
    isFavourite: Boolean
) {

    val activities = TouristActivities()

    Card(
        onClick = onClick,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(130.dp)
            .customShadow(
                color = Color.Black.copy(0.6f),
                borderRadius = 5.dp,
                blurRadius = 6.dp,
                offsetX = 2.dp,
                offsetY = 8.dp,
                spread = 0.dp
            ),
        shape = RoundedCornerShape(5.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Row {
            Box {

                AsyncImage(
                    model = location.images[0],
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(140.dp),
                    contentScale = ContentScale.Crop,
                    contentDescription = "",
                    placeholder = painterResource(id = R.drawable.placeholder)
                )

                if (isFavourite) {
                    Icon(
                        painter = painterResource(R.drawable.favorite),
                        contentDescription = stringResource(R.string.favourite_location),
                        tint = Color(0xFFF2411A),
                        modifier = Modifier
                            .width(30.dp)
                            .height(30.dp)
                            .clip(CircleShape)
                            .padding(4.dp)
                    )
                }
            }

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

                //Displays all the activities as icons belonging to this location
                Row(modifier = Modifier.padding(start = 4.dp)) {
                    activities.icons.forEach { icon ->
                        if (location.icons.contains(icon.name)) {
                            Icon(
                                painter = painterResource(id = icon.icon),
                                contentDescription = icon.name,
                                modifier = Modifier
                                    .height(22.dp)
                                    .width(22.dp)
                                    .padding(2.dp)
                            )
                        }
                    }
                }

                Text(
                    modifier = Modifier.padding(start = 8.dp, bottom = 2.dp),
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