package com.abdelrahman.raafat.budget.tracker.ui.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.abdelrahman.raafat.budget.tracker.R
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition

@Suppress("FunctionName")
@Composable
fun SplashScreen(animationFinished: @Composable () -> Unit) {
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
