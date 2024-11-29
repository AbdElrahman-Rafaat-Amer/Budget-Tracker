package com.abdelrahman.raafat.budget.tracker.ui.splash

import android.app.Application
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.repeatable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.abdelrahman.raafat.budget.tracker.R
import com.abdelrahman.raafat.budget.tracker.ui.custom.BTCustomIndicator
import com.abdelrahman.raafat.budget.tracker.ui.custom.NumberPad
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppColors
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppTextStyles
import com.abdelrahman.raafat.budget.tracker.ui.theme.BudgetTrackerTheme

@Suppress("FunctionName")
@Composable
fun PinScreen(
    viewModel: SplashViewModel,
    isFirstTime: Boolean,
    onNextPage: () -> Unit,
) {
    val pinsValues = remember { MutableList(4) { mutableStateOf("") } }
    var currentIndex by remember { mutableIntStateOf(0) }
    val shakeAnim = remember { Animatable(0f) } // Initial offset is 0f (no shake)

    val title =
        if (isFirstTime) {
            stringResource(R.string.setup_your_pin)
        } else {
            stringResource(R.string.enter_your_pin)
        }

    val errorMessage = stringResource(R.string.incorrect_pin_error_message)
    var message by remember { mutableStateOf(title) }

    // Observe the LiveData for pin correctness
    val pinSate by viewModel.isPinRight.collectAsStateWithLifecycle()

    // React to changes in isPinCorrect
    LaunchedEffect(pinSate) {
        when (pinSate) {
            UiState.Initial -> {
                // Nothing to do
                shakeAnim.snapTo(0f)
            }

            UiState.Success -> {
                onNextPage.invoke()
            }

            UiState.Error -> {
                message = errorMessage
                pinsValues.forEach { it.value = "" }
                currentIndex = 0
                val targetAnimation = 40f
                shakeAnim.animateTo(
                    targetValue = targetAnimation, // Maximum displacement to the right
                    animationSpec =
                        repeatable(
                            iterations = 3, // Number of shakes
                            animation =
                                keyframes {
                                    durationMillis = 400
                                    targetAnimation at 0 // Start with a slight left movement
                                    (-targetAnimation) at 100 // Move to the right
                                    targetAnimation at 200 // Move back left
                                    (-targetAnimation) at 300 // Move right
                                    0f at 400 // End with reset to the original position
                                },
                        ),
                )
                viewModel.resetState()
            }
        }
    }

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier =
            Modifier
                .fillMaxSize()
                .padding(vertical = 70.dp),
    ) {
        Image(
            painter = painterResource(R.drawable.ic_lock),
            contentDescription = null,
            modifier =
                Modifier
                    .size(40.dp)
                    .graphicsLayer {
                        translationX = shakeAnim.value // Apply animated translation to X-axis
                    },
        )

        // Title
        Text(
            text = message,
            color = MaterialTheme.colorScheme.primary,
            style = AppTextStyles.textStyle21SPBold,
            modifier =
                Modifier
                    .graphicsLayer {
                        translationX = shakeAnim.value // Apply animated translation to X-axis
                    },
        )

        // PinView
        Row(horizontalArrangement = Arrangement.spacedBy(7.dp)) {
            pinsValues.forEachIndexed { index, pinValue ->
                BTCustomIndicator(
                    color = AppColors.Transparent,
                    borderColor = MaterialTheme.colorScheme.primary,
                    selectedColor = MaterialTheme.colorScheme.primary,
                    isSelected = index == currentIndex,
                    size = 50.dp,
                    text = pinValue.value,
                    textColor = MaterialTheme.colorScheme.primary,
                )
            }
        }

        // Keyboard
        NumberPad { clickedNumber ->
            message = title
            if (clickedNumber.isNullOrEmpty()) {
                // Delete button clicked
                pinsValues[currentIndex].value = ""
                currentIndex = (currentIndex - 1).coerceAtLeast(0)
            } else {
                // Number button clicked
                pinsValues[currentIndex].value = clickedNumber
                currentIndex++
                if (currentIndex == pinsValues.size) {
                    val pinValue = pinsValues.joinToString("") { it.value }
                    if (viewModel.pinValue.isEmpty()) {
                        // User enters PIN for the first time
                        viewModel.savePin(pinValue)
                        onNextPage.invoke()
                    } else {
                        // Check if the entered PIN is correct
                        viewModel.checkIfPinIsCorrect(pinValue)
                    }
                }
            }
        }
    }
}

@Suppress("FunctionName")
@Preview(showBackground = true)
@Composable
private fun PinScreenFirstTimePreview() {
    BudgetTrackerTheme {
        PinScreen(
            viewModel = SplashViewModel(Application()),
            isFirstTime = true,
        ) {
        }
    }
}
