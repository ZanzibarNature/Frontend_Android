package com.kawatrainingcenter.zanzibarnature.ui.pages.contribute

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.kawatrainingcenter.zanzibarnature.ui.components.AppScaffold

@Composable
fun ContributePage(
    navController: NavController
) {
    AppScaffold(title = "Contribute", navController = navController) {
        Text(text = "Contribute Page", modifier = Modifier.padding(it))
    }
}