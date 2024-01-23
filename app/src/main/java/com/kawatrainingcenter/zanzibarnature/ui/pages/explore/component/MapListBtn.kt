package com.kawatrainingcenter.zanzibarnature.ui.pages.explore.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kawatrainingcenter.zanzibarnature.R
import com.kawatrainingcenter.zanzibarnature.ui.helper.customShadow
import com.kawatrainingcenter.zanzibarnature.ui.theme.ZanzibarNatureTheme

//A button that switched between the map and the list, it changes appearance depending on which is active
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
        colors = ButtonDefaults.buttonColors(containerColor = Color.White),
        //border = BorderStroke(2.dp, MaterialTheme.colorScheme.onSecondary),
        contentPadding = PaddingValues(0.dp),
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .padding(0.dp)
            .width(208.dp)
            .height(45.dp)
            .customShadow(
                color = Color.Black.copy(0.8f),
                borderRadius = 5.dp,
                blurRadius = 6.dp,
                offsetX = 0.dp,
                offsetY = 6.dp,
                spread = 0.dp
            )
    ) {
        Text(
            text = stringResource(R.string.ListView),
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight(400),
                color = if (!isMap) MaterialTheme.colorScheme.onTertiary else MaterialTheme.colorScheme.onBackground.copy(0.6f)
            ),
            modifier = if (!isMap) Modifier
                .offset(x = (-4).dp)
                .background(MaterialTheme.colorScheme.tertiary)
                .height(45.dp)
                .width(105.dp)
                .offset(x = 16.dp, y = 8.dp)
            else Modifier
                .offset(x = (-4).dp)
                .height(45.dp)
                .width(105.dp)
                .offset(x = 16.dp, y = 8.dp)
        )
        
        Text(
            text = stringResource(R.string.MapView),
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight(400),
                color = if (isMap) MaterialTheme.colorScheme.onTertiary else MaterialTheme.colorScheme.onBackground.copy(0.6f)
            ),
            modifier = if (isMap) Modifier
                .background(MaterialTheme.colorScheme.tertiary)
                .height(45.dp)
                .width(110.dp)
                .offset(y = 8.dp, x = 10.dp)
            else Modifier
                .offset(x = 6.dp)
                .height(45.dp)
                .width(110.dp)
                .offset(y = 8.dp)
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