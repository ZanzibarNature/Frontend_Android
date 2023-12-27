package com.kawatrainingcenter.zanzibarnature.ui.pages.about

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.kawatrainingcenter.zanzibarnature.ui.components.AppScaffold

@Composable
fun AboutPage(
    navController: NavController
) {
    AppScaffold(title = "About", navController = navController)
    {
        Text(text = "About page", modifier = Modifier.padding(it))
    }

}