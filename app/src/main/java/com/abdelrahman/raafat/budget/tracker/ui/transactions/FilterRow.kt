package com.abdelrahman.raafat.budget.tracker.ui.transactions

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.abdelrahman.raafat.budget.tracker.R
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppColors

@Suppress("FunctionName")
@Composable
fun FilterRow() {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Card(
            shape = MaterialTheme.shapes.medium.copy(CornerSize(8.dp)),
            colors = CardDefaults.cardColors(containerColor = AppColors.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
            border = BorderStroke(1.dp, AppColors.BorderColor),
            modifier =
                Modifier
                    .size(40.dp)
                    .clip(MaterialTheme.shapes.medium.copy(CornerSize(8.dp)))
                    .clickable {
                    },
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize(),
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_filter),
                    contentDescription = "",
                )
            }
        }

        var expanded by remember { mutableStateOf(false) } // Tracks if the menu is expanded
        val menuItems = listOf("Option 1", "Option 2", "Option 3") // Menu options
        var selectedOption by remember { mutableStateOf("Select an Option") } // Tracks selected item

        Box(
            modifier = Modifier,
//                    .fillMaxWidth()
//                    .wrapContentSize(Alignment.TopStart)
        ) {
            // Trigger for the dropdown menu
            Text(
                text = selectedOption,
                modifier =
                    Modifier
                        .clickable { expanded = true }
                        .background(Color.LightGray)
                        .padding(16.dp),
            )

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }, // Close the menu when clicking outside
            ) {
                menuItems.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option) },
                        onClick = {
                            selectedOption = option // Update the selected option
                            expanded = false // Close the menu
                        },
                    )
                }
            }
        }
        val filterList =
            listOf(
                stringResource(R.string.today),
                stringResource(R.string.yesterday),
            )
//            BTDropDownMenu(
//                menuItems = filterList,
//                textStyle = AppTextStyles.textStyle14SPNormal,
//                placeHolderTextStyle = AppTextStyles.textStyle14SPNormal,
//                placeholderText = stringResource(R.string.category),
//                onItemSelected = {
//
//                },
//            )
    }
}
