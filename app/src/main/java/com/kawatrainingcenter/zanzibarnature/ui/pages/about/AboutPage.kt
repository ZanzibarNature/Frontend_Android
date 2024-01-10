package com.kawatrainingcenter.zanzibarnature.ui.pages.about

import androidx.compose.foundation.Image

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import com.kawatrainingcenter.zanzibarnature.ui.components.button.GoogleMapsButton
import com.kawatrainingcenter.zanzibarnature.ui.components.text.HeaderText
import com.kawatrainingcenter.zanzibarnature.ui.components.text.ParagraphText
import com.kawatrainingcenter.zanzibarnature.ui.components.text.SmallHeaderText
import com.kawatrainingcenter.zanzibarnature.ui.helper.customShadow
import com.kawatrainingcenter.zanzibarnature.ui.pages.about.component.ContactInfo

@Composable
fun AboutPage(
    navController: NavController
) {
    val scrollState = rememberScrollState()

    AppScaffold(title = stringResource(R.string.about), navController = navController)
    {
        Box(
            modifier = Modifier
                .padding(it)
                .verticalScroll(scrollState)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                //Kawa Information
                HeaderText(stringResource(R.string.kawa_foundation))

                ParagraphText(
                    stringResource(R.string.kawa_foundation_text),
                    padding = PaddingValues(bottom = 16.dp)
                )

                //Address
                SmallHeaderText(stringResource(R.string.visit_us))

                ParagraphText(
                    stringResource(R.string.address_kawa),
                    PaddingValues(bottom = 4.dp)
                )

                GoogleMapsButton("https://maps.app.goo.gl/B7XkkG7axUhHDnDy9")

                //Contact Info
                HeaderText(stringResource(R.string.contact))

                ContactInfo(
                    icon = R.drawable.phone,
                    info = stringResource(R.string.kawa_phone_number),
                    padding = PaddingValues(4.dp)
                )

                ContactInfo(
                    icon = R.drawable.mail,
                    info = stringResource(R.string.kawa_email),
                    padding = PaddingValues(4.dp)
                )
            }
        }
    }
}