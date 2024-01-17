package com.kawatrainingcenter.zanzibarnature.ui.pages.about.component

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
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

//This Composable is to display the EmailAddress
//When clicked it opens a dialog with two options: Copy and Mail
//Mail: Opens a Mail app and inserts the email into a new mail
//Copy: Copies the Mail Address to Clipboard
@Composable
fun Email(
    email: String
) {
    val context = LocalContext.current
    val openDialog = remember { mutableStateOf(false) }

    Row(modifier = Modifier.padding(4.dp).clickable { openDialog.value = true }) {
        Image(
            painter = painterResource(R.drawable.mail),
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
                                    val intent = Intent(Intent.ACTION_SEND).apply {
                                        type = "text/plain"
                                        putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
                                    }
                                    if (intent.resolveActivity(context.packageManager) != null) {
                                        context.startActivity(intent)
                                    }
                                },
                            icon = R.drawable.mail, info = stringResource(R.string.send_mail)
                        )

                        Spacer(modifier = Modifier.padding(8.dp))

                        ContactInfo(
                            modifier = Modifier
                                .padding(end = 12.dp, top = 4.dp, bottom = 4.dp, start = 4.dp)
                                .clickable {
                                    openDialog.value = false
                                    val clipboard =
                                        context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                                    val clip = ClipData.newPlainText("Email", email)
                                    clipboard.setPrimaryClip(clip)
                                },
                            icon = R.drawable.copy,
                            info = stringResource(R.string.copy)
                        )
                    }
                },
                confirmButton = { }
            )
        }

        ParagraphText(
            text = email,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}