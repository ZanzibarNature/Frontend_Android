package com.kawatrainingcenter.zanzibarnature.ui.components.textfield

import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.focus.FocusDirection
import kotlin.math.exp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField() {
    var expanded by remember { mutableStateOf(false)}

    DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {

    }
}