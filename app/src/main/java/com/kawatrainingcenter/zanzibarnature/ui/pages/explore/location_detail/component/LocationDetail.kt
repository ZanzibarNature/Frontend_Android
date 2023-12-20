package com.kawatrainingcenter.zanzibarnature.ui.pages.explore.location_detail.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.kawatrainingcenter.zanzibarnature.ui.theme.ZanzibarNatureTheme

@Composable
fun LocationDetail(
    location: Location
) {
    val uriHandler = LocalUriHandler.current

    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        ImageSlider(images = location.images)

        Text(
            text = location.title,
            fontSize = 26.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(8.dp)
        )
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
                contentDescription = "image description",
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
            )
        )
    }
}