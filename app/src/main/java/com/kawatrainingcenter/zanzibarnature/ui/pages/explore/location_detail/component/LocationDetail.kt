package com.kawatrainingcenter.zanzibarnature.ui.pages.explore.location_detail.component

import android.graphics.drawable.ShapeDrawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kawatrainingcenter.zanzibarnature.R
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.model.Location
import com.kawatrainingcenter.zanzibarnature.ui.helper.IconType
import com.kawatrainingcenter.zanzibarnature.ui.theme.ZanzibarNatureTheme

@Composable
fun LocationDetail(
    location: Location,
    isFavourite: Boolean,
    onClickFavourite: () -> Unit
) {
    val icons = listOf(
        IconType.Hiking,
        IconType.Swim,
        IconType.Photo,
        IconType.Monkey,
        IconType.Tour,
        IconType.Kawa
    )

    val uriHandler = LocalUriHandler.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(bottom = 20.dp)
            .verticalScroll(rememberScrollState())
    ) {

        Box(modifier = Modifier) {
            ImageSlider(images = location.images)

            Row(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(12.dp)
            ) {
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

        Text(
            text = location.title,
            fontSize = 26.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(top = 8.dp, start = 8.dp, end = 8.dp, bottom = 2.dp)
        )

        Row(modifier = Modifier.padding(start = 4.dp)) {
            icons.forEach { icon ->
                if (location.icons.contains(icon.name)) {
                    Box(modifier = Modifier.padding(end = 8.dp, start = 8.dp, top = 2.dp)) {
                        Icon(
                            painter = painterResource(id = icon.icon),
                            contentDescription = icon.name,
                            modifier = Modifier
                                .height(22.dp)
                                .width(22.dp)
                        )
                    }
                }
            }
        }

        Text(
            text = location.description,
            fontSize = 16.sp,
            modifier = Modifier.padding(16.dp)
        )

        Button(
            onClick = { uriHandler.openUri(location.location) },
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.secondary),
            shape = RoundedCornerShape(size = 5.dp)
        ) {
            Text(
                text = stringResource(R.string.show_in_google_maps),
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight(700),
                    color = MaterialTheme.colorScheme.onSecondary
                )
            )
            Image(
                painter = painterResource(id = R.drawable.mapsicon),
                contentDescription = "google maps icon",
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .width(22.dp)
                    .height(27.dp)
            )
        }
    }

}

@Preview(showSystemUi = true)
@Composable
fun LocationDetailPreview() {
    ZanzibarNatureTheme {
        LocationDetail(
            location = Location(
                id = 2,
                title = "Nungwi Beach",
                description = "A very quiet beach on the outskirts of the island. Very beautiful place to enjoy the sunset.",
                kawa = "Help to keep the beaches clean!\n" +
                        "The Students from the Kawa Training Center often do beach clean-ups along this beach. If you want to support the Kawa Foundation in making Zanzibar a beautiful place again, feel free to contact us or make a donation.",
                icons = listOf("hiking", "photo", "swim"),
                images = listOf("https://cdn-0.johnnyafrica.com/wp-content/uploads/2020/11/dsc00891.jpg"),
                location = "https://maps.app.goo.gl/gNobBCCybvivuWiaA",
                coords = listOf()
            ),
            isFavourite = false,
            onClickFavourite = {}
        )
    }
}