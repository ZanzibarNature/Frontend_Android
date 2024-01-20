package com.kawatrainingcenter.zanzibarnature.ui.pages.explore.location_detail.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.model.Location
import com.kawatrainingcenter.zanzibarnature.ui.components.button.GoogleMapsButton
import com.kawatrainingcenter.zanzibarnature.ui.components.text.ParagraphText
import com.kawatrainingcenter.zanzibarnature.ui.helper.TouristActivities
import com.kawatrainingcenter.zanzibarnature.ui.theme.ZanzibarNatureTheme

@Composable
fun LocationDetail(
    location: Location,
    isFavourite: Boolean,
    onClickFavourite: () -> Unit,
    navigateToContribute: () -> Unit
) {
    val activities = TouristActivities()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {

        //Images with save button
        Box {
            ImageSlider(images = location.images)

            Row(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(12.dp)
            ) {
                SaveButton(isFavourite = isFavourite) {
                    onClickFavourite()
                }
            }
        }

        //Location Name
        Text(
            text = location.title,
            fontSize = 26.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(top = 8.dp, start = 8.dp, end = 8.dp, bottom = 2.dp)
        )

        //Icons
        Row(modifier = Modifier.padding(start = 4.dp)) {
            activities.icons.forEach { icon ->
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

        //Description
        ParagraphText(
            text = location.description,
            padding = PaddingValues(16.dp)
        )

        //If this is a kawa project, then show what Kawa does here
        if (location.kawa != "" && location.kawa?.isNotEmpty() == true) {
            KawaDescription(description = "${location.kawa}", onClick = navigateToContribute)
        }

        //Button with link to google maps location
        GoogleMapsButton(url = location.googleMapsUrl)
    }
}
