package com.abdelrahman.raafat.budget.tracker.ui.transactions

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.abdelrahman.raafat.budget.tracker.R
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppColors
import com.abdelrahman.raafat.budget.tracker.ui.theme.BudgetTrackerTheme
import com.abdelrahman.raafat.budget.tracker.ui.theme.ThemesPreviews

@Suppress("FunctionName")
@Composable
fun FilterRow(
    modifier: Modifier = Modifier,
    onTimeFilterSelected: (selectedOption: TransactionFilter) -> Unit,
    onFilterClicked: () -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier,
    ) {
        var expanded by remember { mutableStateOf(false) }

        var selectedOption by remember { mutableStateOf(TransactionFilter.WEEK) } // Tracks selected item
        Box(
            modifier =
                Modifier
                    .defaultMinSize(minHeight = 40.dp, minWidth = 96.dp)
                    .shadow(1.dp, shape = RoundedCornerShape(40.dp))
                    .background(Color.White)
                    .clickable {
                        expanded = true
                    }.padding(start = 8.dp, end = 16.dp, top = 4.dp, bottom = 4.dp),
            contentAlignment = Alignment.Center,
        ) {
            // Trigger for the dropdown menu
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ) {
                Image(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = "",
                    colorFilter = ColorFilter.tint(AppColors.PrimaryLight),
                )
                Text(text = stringResource(selectedOption.stringRes))
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }, // Close the menu when clicking outside
            ) {
                TransactionFilter.entries.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(stringResource(option.stringRes)) },
                        onClick = {
                            selectedOption = option // Update the selected option
                            expanded = false // Close the menu
                            onTimeFilterSelected(selectedOption)
                        },
                    )
                }
            }
        }

        Box(
            contentAlignment = Alignment.Center,
            modifier =
                Modifier
                    .size(40.dp)
                    .shadow(1.dp, shape = RoundedCornerShape(8.dp))
                    .background(Color.White)
                    .clickable {
                        onFilterClicked()
                    },
        ) {
            Image(
                painter = painterResource(R.drawable.ic_filter),
                contentDescription = "",
                modifier = Modifier.size(30.dp),
            )
        }
    }
}

@ThemesPreviews
@Suppress("FunctionName")
@Composable
private fun FilterRowPreview() {
    BudgetTrackerTheme {
        FilterRow(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
            onFilterClicked = {},
            onTimeFilterSelected = {},
        )
    }
}
