package com.abdelrahman.raafat.budget.tracker.ui.pin

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abdelrahman.raafat.budget.tracker.PreferencesManager
import com.abdelrahman.raafat.budget.tracker.R
import com.abdelrahman.raafat.budget.tracker.ui.custom.BTCustomIndicator
import com.abdelrahman.raafat.budget.tracker.ui.custom.NumberPad
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppColors
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppTextStyles
import com.abdelrahman.raafat.budget.tracker.ui.theme.BudgetTrackerTheme
import kotlinx.coroutines.launch

@Suppress("FunctionName")
@Composable
fun PinScreen(onNextPage: () -> Unit) {
    val pinsValue = remember { MutableList(4) { mutableStateOf("") } }
    var currentIndex by remember { mutableIntStateOf(0) }
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier =
            Modifier
                .fillMaxSize()
                .padding(top = 30.dp, bottom = 50.dp),
    ) {
        Image(
            painter = painterResource(R.drawable.ic_lock),
            contentDescription = null,
            modifier = Modifier.size(40.dp),
        )

        // Title
        Text(
            text = stringResource(R.string.setup_your_pin),
            style = AppTextStyles.textStyle18SPSemiBold,
        )

        // PinView
        Row(horizontalArrangement = Arrangement.spacedBy(7.dp)) {
            pinsValue.forEachIndexed { index, pinValue ->
                BTCustomIndicator(
                    color = AppColors.White,
                    selectedColor = AppColors.Gray,
                    isSelected = index == currentIndex,
                    size = 50.dp,
                    text = pinValue.value,
                    textColor = MaterialTheme.colorScheme.primary,
                )
            }
        }

        Spacer(Modifier.height(20.dp))

        // Keyboard
        NumberPad { clickedNumber ->
            if (clickedNumber.isNullOrEmpty()) {
                // Delete button clicked
                pinsValue[currentIndex].value = ""
                currentIndex = (currentIndex - 1).coerceAtLeast(0)
            } else {
                // Number button clicked
                pinsValue[currentIndex].value = clickedNumber
                currentIndex++
                if (currentIndex == pinsValue.size) {
                    // Save to SP
                    coroutineScope.launch {
                        PreferencesManager(context).savePin(pinsValue.joinToString("") { it.value })
                    }
                    // Move to next screen
                    onNextPage.invoke()
                }
            }
        }
    }
}

@Suppress("FunctionName")
@Preview
@Composable
private fun PinScreenPreview() {
    BudgetTrackerTheme {
        Box(modifier = Modifier.background(Color.Red)) {
            PinScreen {
            }
        }
    }
}
