package com.kawatrainingcenter.zanzibarnature.ui.pages.contribute

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.kawatrainingcenter.zanzibarnature.ui.components.AppScaffold
import com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.component.ChooseAmount

@Composable
fun ContributePage(
    navController: NavController
) {
    AppScaffold(title = "Contribute", navController = navController) {
        Column(modifier = Modifier.padding(it)) {
            Text(
                text = "Donate",
                fontSize = 20.sp,
                fontWeight = FontWeight(700),
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(16.dp)
            )
            ChooseAmount()
        }
    }
}