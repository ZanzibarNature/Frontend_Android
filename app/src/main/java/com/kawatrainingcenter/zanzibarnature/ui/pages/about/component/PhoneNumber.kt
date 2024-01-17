package com.kawatrainingcenter.zanzibarnature.ui.pages.about.component

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.kawatrainingcenter.zanzibarnature.R
import com.kawatrainingcenter.zanzibarnature.ui.components.text.ParagraphText

//This Composable is to display the Phone number
//When clicked it opens a dialog with two options: Copy and Call
//Call: Opens the phone app and inserts the phone number into it
//Copy: Copies the Phone Number to Clipboard
@Composable
fun PhoneNumber(
    phoneNumber: String
) {
    val context = LocalContext.current
    val openDialog = remember { mutableStateOf(false) }

    Row(modifier = Modifier.padding(4.dp).clickable { openDialog.value = true }) {
        Image(
            painter = painterResource(R.drawable.phone),
            contentDescription = "",
            contentScale = ContentScale.None
        )

        if (openDialog.value) {
            AlertDialog(
                onDismissRequest = { openDialog.value = false },
                text = {
                    Column {
                        ContactInfo(
                            modifier = Modifier
                                .padding(end = 12.dp, top = 4.dp, bottom = 4.dp, start = 4.dp)
                                .clickable {
                                    openDialog.value = false
                                    val dialIntent = Intent(
                                        Intent.ACTION_DIAL,
                                        Uri.parse("tel:$phoneNumber")
                                    )
                                    context.startActivity(dialIntent)
                                },
                            icon = R.drawable.phone, info = stringResource(R.string.call)
                        )

                        Spacer(modifier = Modifier.padding(8.dp))

                        ContactInfo(
                            modifier = Modifier
                                .padding(end = 12.dp, top = 4.dp, bottom = 4.dp, start = 4.dp)
                                .clickable {
                                    openDialog.value = false
                                    val clipboard =
                                        context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                                    val clip = ClipData.newPlainText("Phone Number", phoneNumber)
                                    clipboard.setPrimaryClip(clip)
                                },
                            icon = R.drawable.copy,
                            info = stringResource(R.string.copy)
                        )
                    }
                },
                confirmButton = { }
            )}

        ParagraphText(
            text = phoneNumber,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}