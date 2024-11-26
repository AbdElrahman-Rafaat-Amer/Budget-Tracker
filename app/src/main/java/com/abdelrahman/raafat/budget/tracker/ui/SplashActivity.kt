package com.abdelrahman.raafat.budget.tracker.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.abdelrahman.raafat.budget.tracker.MainActivity
import com.abdelrahman.raafat.budget.tracker.PreferencesManager
import com.abdelrahman.raafat.budget.tracker.R
import com.abdelrahman.raafat.budget.tracker.ui.onboarding.OnBoardingActivity
import com.abdelrahman.raafat.budget.tracker.ui.theme.BudgetTrackerTheme
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import kotlinx.coroutines.launch

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BudgetTrackerTheme {
                SplashScreen{
                    navigateToNextScreen()
                }
            }
        }
    }

    private fun navigateToNextScreen() {
        lifecycleScope.launch {
            val showOnboarding = PreferencesManager(application.baseContext).getShowOnboarding()

            if (showOnboarding) {
                startActivity(Intent(this@SplashActivity, OnBoardingActivity::class.java))
            } else {
                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            }
            finish()
        }
    }
}

@Suppress("FunctionName")
@Composable
fun SplashScreen(
    animationFinished : () -> Unit
) {
    val preloaderLottieCompositionResult =
        rememberLottieComposition(
            LottieCompositionSpec.RawRes(
                R.raw.splash_icon,
            ),
        )

    val progress by animateLottieCompositionAsState(preloaderLottieCompositionResult.value)

    LottieAnimation(
        composition = preloaderLottieCompositionResult.value,
    )

    if (progress == 1.0f) {
        animationFinished()
    }
}



@Suppress("FunctionName")
@Preview(showBackground = true)
@Composable
private fun SplashScreenPreview() {
    BudgetTrackerTheme {
        SplashScreen{}
    }
}
