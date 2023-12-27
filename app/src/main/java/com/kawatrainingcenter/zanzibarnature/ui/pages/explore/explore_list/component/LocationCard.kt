package com.kawatrainingcenter.zanzibarnature.ui.pages.explore.explore_list.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.CompositingStrategy
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.model.Location
import com.kawatrainingcenter.zanzibarnature.ui.helper.IconType


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LocationCard(
    location: Location,
    onClick: () -> Unit
) {

    val icons = listOf(
        IconType.Hiking,
        IconType.Swim,
        IconType.Photo,
        IconType.Monkey,
        IconType.Tour,
        IconType.Kawa
    )

    Card(
        onClick = onClick,
        modifier = Modifier
            .padding(8.dp)
            .shadow(elevation = 4.dp, spotColor = Color.Black, ambientColor = Color.Black)
            .fillMaxWidth()
            .height(130.dp),
        shape = RoundedCornerShape(5.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Row {
            AsyncImage(
                model = location.images[0],
                modifier = Modifier
                    .fillMaxHeight()
                    .width(140.dp),
                //painter = painterResource(R.drawable.beach),
                contentScale = ContentScale.Crop,
                contentDescription = ""
            )
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

                Row(modifier = Modifier.padding(start = 4.dp)) {
                    icons.forEach { icon ->
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
                    overflow = TextOverflow.Clip,
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