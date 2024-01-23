package com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.calculator.component.flightForm

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties
import com.kawatrainingcenter.zanzibarnature.R
import com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.calculator.model.Airport


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlightDropdown(
    airports: List<Airport>?,
    type: String,
    onChange: (String) -> Unit,
    onClick: (Airport) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedAirport by remember { mutableStateOf<Airport?>(null) }
    var text by remember { mutableStateOf("") }

    val focusManager = LocalFocusManager.current
    val focusRequester = remember { FocusRequester() }

    //Dropdown that searches through existing airports, when airport is clicked it is added to selectedAirport (sorry very long)
    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 4.dp, top = 8.dp)) {
        Text(
            text = "${type.capitalize()} ${stringResource(R.string.airport)}",
        )
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = false
            },
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(5.dp))
                .background(MaterialTheme.colorScheme.onPrimary)
                .padding(4.dp)
        ) {
            TextField(
                value = text,
                onValueChange = {
                    text = it
                    if (text.length > 2) {
                        onChange(it)
                    }


                    expanded = if (text.length > 2) {
                        airports?.isNotEmpty() == true
                    } else false
                },
                trailingIcon = {
                    if (text.isNotEmpty()) {
                        IconButton(onClick = { text = "" }) {
                            Icon(Icons.Default.Clear, contentDescription = stringResource(R.string.clear_icon))
                        }
                    }
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = { focusManager.moveFocus(FocusDirection.Down) }
                ),
                placeholder = {
                    Text(text = "${stringResource(R.string.Select)} $type ${stringResource(R.string.airport)}")
                },
                colors = TextFieldDefaults.textFieldColors(
                    textColor = MaterialTheme.colorScheme.onTertiary,
                    containerColor = Color.Transparent
                ),
                modifier = Modifier
                    .focusRequester(focusRequester)
                    .menuAnchor()
                    .fillMaxWidth()
                    .onKeyEvent { event ->
                        event.key == Key.Backspace && text.isEmpty()
                    }
            )
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = {
                    expanded = false
                },
                properties = PopupProperties(focusable = false),
                modifier = Modifier
                    .fillMaxWidth(.9f)
                    .fillMaxHeight(.2f)
                    .background(MaterialTheme.colorScheme.background)
            ) {
                airports?.forEach { airport ->
                    DropdownMenuItem(
                        text = {
                            Text(
                                text = airport.name.toString(),
                                color = MaterialTheme.colorScheme.onBackground,
                                modifier = Modifier.fillMaxWidth()
                            )
                        },
                        onClick = {
                            selectedAirport = airport
                            text = airport.name.toString()
                            expanded = false
                            onClick(airport)
                            focusManager.moveFocus(FocusDirection.Down)
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}

