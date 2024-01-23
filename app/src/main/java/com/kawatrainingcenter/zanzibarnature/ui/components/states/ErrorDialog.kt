package com.kawatrainingcenter.zanzibarnature.ui.components.states

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.kawatrainingcenter.zanzibarnature.R
import com.kawatrainingcenter.zanzibarnature.ui.components.text.SmallHeaderText

//Error pop up, with retry button.
@Composable
fun ErrorDialog(
    modifier: Modifier = Modifier,
    message: String? = null,
    retry: () -> Unit = {}
) {
    val openDialog = remember { mutableStateOf(false) }

    AlertDialog(
        onDismissRequest = { openDialog.value = false },
        text = {
            Column {
                Row {
                    Image(
                        painter = painterResource(R.drawable.baseline_error_24),
                        contentDescription = "",
                        contentScale = ContentScale.None,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    SmallHeaderText(text = stringResource(R.string.error_text))
                }

                Spacer(modifier = Modifier.padding(4.dp))

                Text(message ?: stringResource(R.string.unknown_error))

                Spacer(modifier = Modifier.padding(8.dp))

                Text(text = stringResource(R.string.try_again))
            }
        },
        confirmButton = {
            Button(
                onClick = retry,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colorScheme.tertiary,
                    contentColor = MaterialTheme.colorScheme.onTertiary
                ),
                modifier = Modifier.width(150.dp)
            ) {
                Text(text = stringResource(R.string.retry))
            }
        },
    )
}
