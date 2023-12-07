package com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.calculator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.kawatrainingcenter.zanzibarnature.R
import com.kawatrainingcenter.zanzibarnature.ui.components.AppScaffold
import com.kawatrainingcenter.zanzibarnature.ui.components.button.DefaultBtn
import com.kawatrainingcenter.zanzibarnature.ui.components.states.ErrorMessage
import com.kawatrainingcenter.zanzibarnature.ui.components.states.LoadingIndicator
import com.kawatrainingcenter.zanzibarnature.ui.navigation.NavigationType
import com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.calculator.model.CompensationState

@Composable
fun CalculatorPage(
    navController: NavController,
    viewModel: CalculatorViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    AppScaffold(
        title = "Contribute",
        navController = navController,
        navigation = NavigationType.Back { navController.popBackStack() }
    ) {
        Column(modifier = Modifier.padding(it), verticalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = "Calculator",
                fontSize = 20.sp,
                fontWeight = FontWeight(700),
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(16.dp)
            )
            Spacer(modifier = Modifier.padding(20.dp))
            when (val state = state) {
                CompensationState.Loading -> LoadingIndicator()

                is CompensationState.Success -> {
                    Text(
                        text = state.compensation.total.toString(),
                        modifier = Modifier.padding(it)
                    )
                }

                is CompensationState.Error -> ErrorMessage(message = state.message)
            }
            Spacer(modifier = Modifier.padding(100.dp))
            DefaultBtn(onClick = { /*TODO*/ }, text = stringResource(R.string.donate))
        }
    }
}