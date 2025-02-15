package com.abdelrahman.raafat.budget.tracker.ui.custom

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import com.abdelrahman.raafat.budget.tracker.R
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.item.Category
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.transaction.PaymentMethod
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppColors

@Suppress("FunctionName")
@Composable
fun <T> BTDropDownMenu(
    textStyle: TextStyle,
    placeHolderTextStyle: TextStyle,
    menuItems: List<T>,
    placeholderText: String,
    onItemSelected: (T) -> Unit,
) {
    var mExpanded by remember { mutableStateOf(false) }

    var value by remember { mutableStateOf("") }

    // Up Icon when expanded and down icon when collapsed
    val icon =
        if (mExpanded) {
            Icons.Filled.KeyboardArrowUp
        } else {
            Icons.Filled.KeyboardArrowDown
        }

    Column {
        BTOutlinedTextField(
            value = value,
            onValueChange = {},
            placeholderText = placeholderText,
            textStyle = textStyle,
            placeholderTextStyle = placeHolderTextStyle,
            isEnabled = false,
            trailingIcon = {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                )
            },
            isClickable = true,
            onClick = { mExpanded = mExpanded.not() },
        )

        // Create a drop-down menu with list of cities,
        // when clicked, set the Text Field text as the city selected
        DropdownMenu(
            expanded = mExpanded,
            onDismissRequest = { mExpanded = false },
            containerColor = AppColors.White,
        ) {
            menuItems.forEach { label ->
                val text =
                    when (label) {
                        is PaymentMethod -> stringResource(label.titleResId)
                        is Category -> stringResource(label.titleResId)
                        is String -> label
                        else -> stringResource(R.string.other)
                    }
                DropdownMenuItem(
                    onClick = {
                        onItemSelected(label)
                        value = text
                        mExpanded = false
                    },
                    text = { Text(text = text, style = textStyle) },
                    modifier = Modifier,
                )
            }
        }
    }
}
