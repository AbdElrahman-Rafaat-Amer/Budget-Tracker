package com.abdelrahman.raafat.budget.tracker.ui.custom

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abdelrahman.raafat.budget.tracker.ui.theme.BudgetTrackerTheme

@Suppress("FunctionName")
@Composable
fun BTCheckbox(
    text: String,
    isAllCaps: Boolean = false,
    onCheckedChange: (isChecked: Boolean) -> Unit,
) {
    var checked by remember { mutableStateOf(false) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier =
            Modifier
                .padding(end = 10.dp)
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() },
                    onClick = {
                        checked = !checked
                        onCheckedChange(checked)
                    },
                ),
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = {
                checked = it
                onCheckedChange(it)
            },
        )
        Text(
            text =
                if (isAllCaps) {
                    text.uppercase()
                } else {
                    text
                },
        )
    }
}

@Suppress("FunctionName")
@Preview(showBackground = true)
@Composable
private fun BTCheckboxPreview() {
    BudgetTrackerTheme {
        BTCheckbox("check Me") {
        }
    }
}
