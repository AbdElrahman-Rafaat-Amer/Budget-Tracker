package com.abdelrahman.raafat.budget.tracker.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import com.abdelrahman.raafat.budget.tracker.R
import com.abdelrahman.raafat.budget.tracker.ui.onboarding.OnBoardingActivity
import com.abdelrahman.raafat.budget.tracker.ui.theme.BudgetTrackerTheme
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BudgetTrackerTheme {
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
                    startActivity(Intent(this, OnBoardingActivity::class.java))
                    finish()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    BudgetTrackerTheme {
        SplashActivity()
    }
}
