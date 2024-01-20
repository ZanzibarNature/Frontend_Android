package com.kawatrainingcenter.zanzibarnature.ui.components.button

import android.content.Intent
import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import com.kawatrainingcenter.zanzibarnature.R
import java.text.NumberFormat
import java.util.Locale

@Composable
fun DonateButton(
    amount: Int
) {
    //val uriHandler = LocalUriHandler.current
    val context = LocalContext.current

    //FormatNumber function for readability, puts '.' between long numbers, for example: 100000 -> 100.000
    fun formatNumber(number: Int): String {
        val format = NumberFormat.getNumberInstance(Locale.GERMANY)
        return format.format(number)
    }

    fun openPaypal(amount: Int) {
        val openURL = Intent(Intent.ACTION_VIEW)
        openURL.data = Uri.parse("https://www.sandbox.paypal.com/donate/?hosted_button_id=ZHADHAHE9FXT8&amount=${amount}")
        context.startActivity(openURL)

    }

    DefaultBtn(
        onClick = { openPaypal(amount) },
        enabled = amount != 0,
        text =
        if (amount != 0) "${stringResource(R.string.donate)} ${
            stringResource(
                R.string.currency_symbol
            )
        }${formatNumber(amount)}"
        else stringResource(R.string.donate)
    )
}