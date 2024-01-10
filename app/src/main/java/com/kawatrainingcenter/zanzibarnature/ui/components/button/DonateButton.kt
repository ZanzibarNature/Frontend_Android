package com.kawatrainingcenter.zanzibarnature.ui.components.button

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import com.kawatrainingcenter.zanzibarnature.R
import java.text.NumberFormat
import java.util.Locale

@Composable
fun DonateButton(
    amount: Int
) {
    val uriHandler = LocalUriHandler.current

    //FormatNumber function for readability, puts '.' between long numbers, for example: 100000 -> 100.000
    fun formatNumber(number: Int): String {
        val format = NumberFormat.getNumberInstance(Locale.GERMANY)
        return format.format(number)
    }

    DefaultBtn(
        onClick = { uriHandler.openUri("https://www.paypal.com/donate?token=-DWIqPILgSa-E_sf6a_0Of6mlyzPOP0_bczmXNt2GMBlEjZit0zo0XYeYXzmyGiVhgpiBM6VVv4PY0Rg") },
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