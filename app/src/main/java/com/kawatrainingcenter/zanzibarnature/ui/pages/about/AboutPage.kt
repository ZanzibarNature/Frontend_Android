package com.kawatrainingcenter.zanzibarnature.ui.pages.about

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.kawatrainingcenter.zanzibarnature.R
import com.kawatrainingcenter.zanzibarnature.ui.components.AppScaffold
import com.kawatrainingcenter.zanzibarnature.ui.components.button.GoogleMapsButton
import com.kawatrainingcenter.zanzibarnature.ui.components.text.HeaderText
import com.kawatrainingcenter.zanzibarnature.ui.components.text.ParagraphText
import com.kawatrainingcenter.zanzibarnature.ui.components.text.SmallHeaderText
import com.kawatrainingcenter.zanzibarnature.ui.pages.about.component.Email
import com.kawatrainingcenter.zanzibarnature.ui.pages.about.component.PhoneNumber

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
                    text = stringResource(R.string.kawa_foundation_text),
                    padding = PaddingValues(bottom = 16.dp)
                )

                //Address
                SmallHeaderText(stringResource(R.string.visit_us))

                ParagraphText(
                    text = stringResource(R.string.address_kawa),
                    padding = PaddingValues(bottom = 4.dp)
                )

                GoogleMapsButton("https://maps.app.goo.gl/B7XkkG7axUhHDnDy9")

                //Contact Info
                HeaderText(stringResource(R.string.contact))

                PhoneNumber(phoneNumber = stringResource(R.string.kawa_phone_number))
                Email(email = stringResource(R.string.kawa_email))
            }
        }
    }
}