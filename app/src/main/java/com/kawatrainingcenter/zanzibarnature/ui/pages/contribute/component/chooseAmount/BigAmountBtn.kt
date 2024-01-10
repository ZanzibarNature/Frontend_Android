package com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.component.chooseAmount

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kawatrainingcenter.zanzibarnature.R
import com.kawatrainingcenter.zanzibarnature.ui.helper.customShadow

@Composable
fun BigAmountBtn(
    id: Int = 0,
    label: String,
    isActive: Boolean,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        shape =  RoundedCornerShape(size = 5.dp),
        modifier = Modifier
            .padding(start = 8.dp, end = 8.dp, top = 8.dp, bottom = 8.dp)
            .border(
                width = if (isActive) 2.5.dp else 1.5.dp,
                color = if (isActive) MaterialTheme.colorScheme.tertiary else MaterialTheme.colorScheme.onBackground,
                shape = RoundedCornerShape(size = 5.dp)
            )
            .fillMaxWidth(0.965f)
            .height(75.dp)
            .background(
                color = MaterialTheme.colorScheme.background,
                shape = RoundedCornerShape(size = 5.dp)
            )
            .customShadow(
                color = if(isActive) Color.Transparent else Color.Black.copy(0.8f),
                borderRadius = 5.dp,
                blurRadius = 6.dp,
                offsetX = 4.dp,
                offsetY = 6.dp,
                spread = 0.dp
            ),
        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.background),
        contentPadding = PaddingValues(0.dp)
    ) {
        Text(
            modifier = Modifier.align(Alignment.CenterVertically),
            text = label,
            fontSize = 17.sp,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = if(isActive) FontWeight(600) else FontWeight.Normal
        )
    }
}