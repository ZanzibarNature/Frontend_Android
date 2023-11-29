package com.kawatrainingcenter.zanzibarnature.ui.pages.location_detail.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kawatrainingcenter.zanzibarnature.R
import com.kawatrainingcenter.zanzibarnature.data.model.Location

@Preview(showSystemUi = true)
@Composable
fun LocationDetail(
    location: Location = Location(
        id = 2,
        title = "Nungwi Beach",
        description = "A very quiet beach on the outskirts of the island. Very beautiful place to enjoy the sunset.",
        kawa = "Help to keep the beaches clean!\n" +
                "The Students from the Kawa Training Center often do beach clean-ups along this beach. If you want to support the Kawa Foundation in making Zanzibar a beautiful place again, feel free to contact us or make a donation.",
        icons = listOf("hiking", "photo", "swim"),
        image = "https://cdn-0.johnnyafrica.com/wp-content/uploads/2020/11/dsc00891.jpg",
        location = "hier"
    )
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
//        AsyncImage(
//            model = location.image,
//            contentDescription = "",
//            modifier = Modifier.height(280.dp)
//   )
        Image(
            painter = painterResource(id = R.drawable.beach), contentDescription = "",
            modifier = Modifier
                .height(280.dp)
                .fillMaxWidth()
        )
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
    }

}