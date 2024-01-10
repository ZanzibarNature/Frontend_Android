package com.kawatrainingcenter.zanzibarnature.ui.components.button

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kawatrainingcenter.zanzibarnature.R
import com.kawatrainingcenter.zanzibarnature.ui.helper.customShadow

@Composable
fun GoogleMapsButton(
    url: String
) {

    val uriHandler = LocalUriHandler.current

    Button(
        onClick = { uriHandler.openUri(url) },
        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.secondary),
        shape = RoundedCornerShape(size = 5.dp),
        modifier = Modifier
            .padding(bottom = 16.dp)
            .customShadow(
                color = Color.Black.copy(0.4f),
                borderRadius = 5.dp,
                blurRadius = 4.dp,
                offsetX = 2.dp,
                offsetY = 8.dp,
                spread = 0.dp
            ),
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