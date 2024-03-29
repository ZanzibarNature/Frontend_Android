package com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.component.chooseAmount

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kawatrainingcenter.zanzibarnature.R
import com.kawatrainingcenter.zanzibarnature.ui.helper.customShadow
import java.text.NumberFormat
import java.util.Locale

//The user can enter it's own amount using this button/ textfield
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnterAmountBtn(
    amount: Int,
    isActive: Boolean = false,
    onClick: () -> Unit,
    onChange: (Int) -> Unit
) {
    var text by remember { mutableStateOf(amount.toString()) }
    val focusManager = LocalFocusManager.current

    fun formatNumber(number: Int): String {
        val format = NumberFormat.getNumberInstance(Locale.GERMANY)
        return format.format(number)
    }

    if (isActive) {
        TextField(
            value = if (text == "0") "" else text,
            onValueChange = {
                if (it.length < 10) {
                    text = it.filter { number -> number.isDigit() }
                    if (text != "") onChange(text.toInt()) else onChange(0)
                    onClick()
                }
            },
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
                fontWeight = FontWeight(600)
            ),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = MaterialTheme.colorScheme.background,
                textColor = MaterialTheme.colorScheme.onBackground
            ),
            modifier = Modifier
                .padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 4.dp)
                .border(
                    width = 2.5.dp,
                    color = MaterialTheme.colorScheme.tertiary,
                    shape = RoundedCornerShape(size = 5.dp)
                )
                .width(175.dp)
                .height(75.dp)
        )
    } else {
        Button(
            onClick = {
                if (text != "") {
                    if (text.toInt() > 0) onChange(text.toInt())
                }
                onClick()
            },
            shape = RoundedCornerShape(5.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.background,
                contentColor = MaterialTheme.colorScheme.onBackground
            ),
            contentPadding = PaddingValues(0.dp),
            modifier = Modifier
                .padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 4.dp)
                .border(
                    width = 1.5.dp,
                    color = MaterialTheme.colorScheme.onBackground,
                    shape = RoundedCornerShape(size = 5.dp)
                )
                .width(175.dp)
                .height(75.dp)
                .customShadow(
                    color = Color.Black.copy(0.8f),
                    borderRadius = 5.dp,
                    blurRadius = 6.dp,
                    offsetX = 4.dp,
                    offsetY = 6.dp,
                    spread = 0.dp
                ),
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text =
                    if (text == "" || text == "0") stringResource(R.string.enter_amount)
                    else "${stringResource(R.string.currency_symbol)}${formatNumber(text.toInt())}",
                    fontSize = 17.sp,
                    fontWeight = FontWeight(400),
                    overflow = TextOverflow.Clip,
                    style = TextStyle(
                        color = MaterialTheme.colorScheme.onBackground,
                        textAlign = TextAlign.Center,
                    )
                )
            }

        }
    }
}