package com.kawatrainingcenter.zanzibarnature.ui.pages.about

import androidx.compose.foundation.Image

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.navigation.NavController
import com.kawatrainingcenter.zanzibarnature.R
import com.kawatrainingcenter.zanzibarnature.ui.components.AppScaffold
import com.kawatrainingcenter.zanzibarnature.ui.helper.customShadow

@Composable
fun AboutPage(
    navController: NavController
) {
    val uriHandler = LocalUriHandler.current
    val scrollState = rememberScrollState()

    AppScaffold(title = stringResource(R.string.about), navController = navController)
    {
        Box(
            modifier = Modifier
                .padding(it)
                .verticalScroll(scrollState)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = stringResource(R.string.kawa_foundation),
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight(700),
                        color = MaterialTheme.colorScheme.onBackground,
                    ),
                )

                Text(
                    text = stringResource(R.string.kawa_foundation_text),
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight(400),
                        color = MaterialTheme.colorScheme.onBackground,
                    ),
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                Text(
                    text = stringResource(R.string.visit_us),
                    style = TextStyle(
                        fontSize = 17.sp,
                        fontWeight = FontWeight(700),
                        color = MaterialTheme.colorScheme.onBackground,
                    )
                )
                Text(
                    text = stringResource(R.string.address_kawa),
                    style = TextStyle(
                        fontSize = 17.sp,
                        fontWeight = FontWeight(400),
                        color = MaterialTheme.colorScheme.onBackground,
                    ),
                    modifier = Modifier.padding(bottom = 4.dp)
                )

                Button(
                    onClick = { uriHandler.openUri("https://maps.app.goo.gl/B7XkkG7axUhHDnDy9") },
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

                Text(
                    text = stringResource(R.string.contact),
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight(700),
                        color = MaterialTheme.colorScheme.onBackground,
                    )
                )

                Row(modifier = Modifier.padding(4.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.phone),
                        contentDescription = "",
                        contentScale = ContentScale.None
                    )

                    Text(
                        text = stringResource(R.string.kawa_phone_number),
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight(400),
                            color = MaterialTheme.colorScheme.onBackground,
                        ),
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }

                Row(modifier = Modifier.padding(4.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.mail),
                        contentDescription = "",
                        contentScale = ContentScale.None
                    )

                    Text(
                        text = stringResource(R.string.kawa_email),
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight(400),
                            color = MaterialTheme.colorScheme.onBackground,
                        ),
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }


            }

        }
    }

}