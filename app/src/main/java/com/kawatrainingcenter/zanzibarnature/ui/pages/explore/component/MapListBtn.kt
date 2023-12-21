package com.kawatrainingcenter.zanzibarnature.ui.pages.explore.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kawatrainingcenter.zanzibarnature.R
import com.kawatrainingcenter.zanzibarnature.ui.theme.ZanzibarNatureTheme

@Composable
fun MapListBtn(
    onClick: () -> Unit,
    map: Boolean
) {
    var isMap by remember { mutableStateOf(map) }

    Button(
        onClick = {
            onClick()
            isMap = !isMap
        },
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary),
        border = BorderStroke(2.dp, MaterialTheme.colorScheme.onSecondary),
        modifier = Modifier
            .padding(0.dp)
            .shadow(
                elevation = 6.dp,
                spotColor = Color(0x40000000),
                ambientColor = Color(0x40000000),
                shape = RoundedCornerShape(20.dp)
            )
            .width(225.dp)
            .height(40.dp)
    ) {
        Text(
            text = "${stringResource(R.string.ListView)}  ",
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight(400),
                color = if (!isMap) MaterialTheme.colorScheme.onSecondary else MaterialTheme.colorScheme.onBackground.copy(0.25f)
            )
        )

        Text(
            text = "  ${stringResource(R.string.MapView)}",
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight(400),
                color = if (isMap) MaterialTheme.colorScheme.onSecondary else MaterialTheme.colorScheme.onBackground.copy(0.25f)
            )
        )

    }
}

@Preview
@Composable
fun MapListBtnPreview() {
    ZanzibarNatureTheme {
        MapListBtn(onClick = {}, map = false)
    }
}