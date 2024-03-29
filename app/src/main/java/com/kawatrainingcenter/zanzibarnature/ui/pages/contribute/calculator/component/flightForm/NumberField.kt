package com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.calculator.component.flightForm

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NumberField(
    label: String,
    onChange: (Int) -> Unit
) {
    var number by remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current

    Column (modifier = Modifier.padding(start = 16.dp, end = 16.dp,  bottom = 4.dp, top = 8.dp)) {
        Text(text = label)
        TextField(
            value = if (number == "0") "" else number,
            onValueChange = {
                if(it.length < 5) {
                    number = it.filter { num -> num.isDigit() }
                    if(number != "") onChange( number.toInt() ) else onChange(0)
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
                fontSize = 16.sp,
                fontWeight = FontWeight(400)
            ),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = MaterialTheme.colorScheme.onPrimary,
                textColor = MaterialTheme.colorScheme.onTertiary
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }

}