package com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.kawatrainingcenter.zanzibarnature.R
import com.kawatrainingcenter.zanzibarnature.ui.components.AppScaffold
import com.kawatrainingcenter.zanzibarnature.ui.components.button.DefaultBtn
import com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.component.BigAmountBtn
import com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.component.ChooseAmount

@Composable
fun ContributePage(
    navController: NavController,
    viewModel: ContributeViewModel = hiltViewModel()
) {

    val uriHandler = LocalUriHandler.current
    val enteredAmount by viewModel.entered.collectAsState()

    AppScaffold(title = "Contribute", navController = navController) {
        Column(modifier = Modifier.padding(it)) {
            Text(
                text = "Donate",
                fontSize = 20.sp,
                fontWeight = FontWeight(700),
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(16.dp)
            )

            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                ChooseAmount(
                    enteredAmount = enteredAmount,
                    onChange = { data -> viewModel.updateEntered(data) }
                )

                BigAmountBtn(
                    onClick = { navController.navigate("calculator") },
                    label = stringResource(R.string.calculate_co2),
                    isActive = false
                )

                Spacer(modifier = Modifier.padding(100.dp))

                DefaultBtn(onClick = { uriHandler.openUri("https://www.paypal.com/donate?token=-DWIqPILgSa-E_sf6a_0Of6mlyzPOP0_bczmXNt2GMBlEjZit0zo0XYeYXzmyGiVhgpiBM6VVv4PY0Rg")}, text = stringResource(R.string.donate))
            }
        }


    }
}