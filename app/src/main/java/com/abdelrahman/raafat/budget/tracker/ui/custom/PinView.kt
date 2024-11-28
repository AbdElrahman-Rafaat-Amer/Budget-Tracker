package com.abdelrahman.raafat.budget.tracker.ui.custom

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppTextStyles

@Suppress("FunctionName")
@Composable
fun PinView(pinsValue: List<MutableState<String>>) {
    Row(horizontalArrangement = Arrangement.spacedBy(7.dp)) {
        pinsValue.forEach { pinsValue ->
            TextField(
                pinsValue.value,
                onValueChange = {
                    if (it.length < 2) {
                        pinsValue.value = it
                    }
                },
                maxLines = 1,
                shape = CircleShape,
                textStyle = AppTextStyles.textStyle15SPMedium.copy(textAlign = TextAlign.Center),
                modifier =
                    Modifier
                        .size(50.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors =
                    TextFieldDefaults.colors(
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                    ),
            )
        }
    }
}
