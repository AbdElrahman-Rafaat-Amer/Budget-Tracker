package com.abdelrahman.raafat.budget.tracker.ui.custom

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abdelrahman.raafat.budget.tracker.ui.theme.BudgetTrackerTheme

@Suppress("FunctionName")
@Composable
fun BTPrimaryButton(
    text: String,
    modifier: Modifier = Modifier,
    isAllCaps: Boolean = true,
    isTextButton: Boolean = false,
    onButtonClicked: () -> Unit,
) {
    val buttonColors =
        if (isTextButton) {
            ButtonDefaults.textButtonColors()
        } else {
            ButtonDefaults.buttonColors()
        }

    val buttonBorders =
        if (isTextButton) {
            null
        } else {
            BorderStroke(2.dp, MaterialTheme.colorScheme.primary)
        }

    val paddingValues =
        if (isTextButton) {
            PaddingValues(0.dp)
        } else {
            PaddingValues(15.dp)
        }

    Button(
        onClick = {
            onButtonClicked.invoke()
        },
        modifier =
            modifier
                .fillMaxWidth()
                .apply {
                    if (isTextButton) {
                        Modifier
                    } else {
                        defaultMinSize(minHeight = 50.dp)
                    }
                },
        shape = RoundedCornerShape(size = 14.dp),
        colors = buttonColors,
        border = buttonBorders,
        contentPadding = paddingValues,
    ) {
        Text(
            modifier = modifier,
            text =
                if (isAllCaps) {
                    text.uppercase()
                } else {
                    text
                },
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Suppress("FunctionName")
@Preview(showBackground = true)
@Composable
private fun BTPrimaryButtonPreview() {
    BudgetTrackerTheme {
        Column {
            BTPrimaryButton(
                text = "Next",
                onButtonClicked = {},
            )

            Spacer(Modifier.height(20.dp))

            BTPrimaryButton(
                text = "Skip",
                isTextButton = true,
                onButtonClicked = {},
            )
        }
    }
}
