package com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kawatrainingcenter.zanzibarnature.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnterAmountBtn(
    id: Int,
    amount: Int? = 0,
    isActive: Boolean = false,
    onClick: () -> Unit
) {
    var text by remember { mutableStateOf(amount.toString()) }
    val focusManager = LocalFocusManager.current

    //Todo make button and add two textfields -> one readonly with currency symbol
    TextField(
        value = "${stringResource(R.string.currency_symbol)}$text",
        onValueChange = {
            text = it.filter{ number -> number.isDigit()}
            onClick()
        },
        shape = RoundedCornerShape(5.dp),
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(
            onNext = { focusManager.moveFocus(FocusDirection.Down) }
        ),
        textStyle = TextStyle(
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            fontWeight = if (isActive) FontWeight(600) else FontWeight.Normal
        ),
        modifier = Modifier
            .padding(start = 10.dp, end = 10.dp, top = 8.dp, bottom = 8.dp)
            .border(
                width = if (isActive) 2.5.dp else 1.5.dp,
                color = if (isActive) MaterialTheme.colorScheme.tertiary else MaterialTheme.colorScheme.onBackground,
                shape = RoundedCornerShape(size = 5.dp)
            )
            .width(170.dp)
            .height(75.dp)
            .shadow(
                elevation = if (isActive) 0.dp else 3.dp,
                spotColor = Color(0x4D000000),
                ambientColor = Color(0x4D000000)
            ),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = MaterialTheme.colorScheme.background,
            textColor = MaterialTheme.colorScheme.onBackground
        )
    )
}