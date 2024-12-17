package com.abdelrahman.raafat.budget.tracker.ui.splash

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abdelrahman.raafat.budget.tracker.R
import com.abdelrahman.raafat.budget.tracker.ui.custom.BTLottie
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppTextStyles
import com.abdelrahman.raafat.budget.tracker.ui.theme.BudgetTrackerTheme
import kotlinx.coroutines.delay

@Suppress("FunctionName")
@Composable
fun SplashScreen(animationFinished: @Composable () -> Unit) {
    var isVisible by remember { mutableStateOf(false) }

    // Trigger animation after composition
    LaunchedEffect(Unit) {
        delay(500)
        isVisible = true
    }

    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(bottom = 100.dp, start = 20.dp, end = 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        BTLottie(
            lottieRes = R.raw.splash_icon,
            modifier = Modifier.weight(1f),
            animationFinished = { animationFinished() },
        )
        AnimatedVisibility(
            visible = isVisible,
            enter =
                slideInVertically(
                    initialOffsetY = { 500 },
                    animationSpec = tween(durationMillis = 1000),
                ),
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = stringResource(R.string.welcome),
                    style =
                        AppTextStyles.textStyle21SPBold.copy(
                            color = MaterialTheme.colorScheme.primary,
                        ),
                )
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = stringResource(R.string.welcome_message),
                    style =
                        AppTextStyles.textStyle18SPNormal.copy(
                            color = MaterialTheme.colorScheme.secondary,
                            textAlign = TextAlign.Center,
                        ),
                )
            }
        }
    }
}

@Preview
@Suppress("FunctionName")
@Composable
private fun SplashScreenPreview() {
    BudgetTrackerTheme {
        SplashScreen {}
    }
}
