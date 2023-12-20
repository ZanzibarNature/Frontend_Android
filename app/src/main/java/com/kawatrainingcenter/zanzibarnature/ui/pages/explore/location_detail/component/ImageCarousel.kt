package com.kawatrainingcenter.zanzibarnature.ui.pages.explore.location_detail.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed

import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ImageSlider(
    images: List<String>
) {

    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp.dp

    val pagerState = rememberPagerState(initialPage = 0)

    Box(
        modifier = Modifier
            .height(350.dp)
            .fillMaxWidth()
    ) {

            HorizontalPager(
                count = images.count(),
                state = pagerState,
                modifier = Modifier.fillMaxWidth().height(280.dp)
            ) { page ->
                Card(
                    shape = RectangleShape,
                    modifier = Modifier
                        .width(screenWidthDp)
                        .fillMaxHeight()
                ) {
                    AsyncImage(
                        model = images[page],
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(),
                        contentScale = ContentScale.Crop,
                        contentDescription = ""
                    )
                }
            }

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 250.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            items(images.count()) { index ->
                Text(
                    text = ".",
                    style = TextStyle(
                        fontSize = 50.sp,
                        fontWeight = FontWeight(400),
                        color = if (index == pagerState.currentPage) MaterialTheme.colorScheme.onBackground else MaterialTheme.colorScheme.onBackground.copy(0.5f)
                    )
                )
            }
        }
    }
}