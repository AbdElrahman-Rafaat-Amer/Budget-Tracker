package com.abdelrahman.raafat.budget.tracker.ui.custom

import androidx.annotation.RawRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition

@Suppress("FunctionName")
@Composable
fun BTLottie(
    @RawRes lottieRes: Int,
    iterations: Int = 1,
    modifier: Modifier = Modifier,
    animationFinished: @Composable () -> Unit = {},
) {
    val preloaderLottieCompositionResult =
        rememberLottieComposition(
            LottieCompositionSpec.RawRes(
                lottieRes,
            ),
        )

    val progress by animateLottieCompositionAsState(
        composition = preloaderLottieCompositionResult.value,
        iterations = iterations,
    )

    LottieAnimation(
        composition = preloaderLottieCompositionResult.value,
        progress = { progress },
        modifier = modifier,
    )

    if (progress == 1.0f && iterations != LottieConstants.IterateForever) {
        animationFinished()
    }
}
