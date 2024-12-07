package com.abdelrahman.raafat.budget.tracker.ui.custom

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.toSize
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppColors

@Suppress("FunctionName")
@Composable
fun BTDropDownMenu(
    textStyle: TextStyle,
    placeHolderTextStyle: TextStyle,
    menuItems: List<String>,
    placeholderText: String,
    onItemSelected: (title: String) -> Unit,
    value: MutableState<String>,
) {
    var mExpanded by remember { mutableStateOf(false) }

    var mTextFieldSize by remember { mutableStateOf(Size.Zero) }

    // Up Icon when expanded and down icon when collapsed
    val icon =
        if (mExpanded) {
            Icons.Filled.KeyboardArrowUp
        } else {
            Icons.Filled.KeyboardArrowDown
        }

    Column {
        BTOutlinedTextField(
            modifier =
                Modifier
                    .onGloballyPositioned { coordinates ->
                        // This value is used to assign to the DropDown the same width
                        mTextFieldSize = coordinates.size.toSize()
                    },
            value = value.value,
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
            modifier =
                Modifier
                    .width(with(LocalDensity.current) { mTextFieldSize.width.toDp() }),
            containerColor = AppColors.White,
        ) {
            menuItems.forEach { label ->
                DropdownMenuItem(
                    onClick = {
                        onItemSelected(label)
                        mExpanded = false
                    },
                    text = { Text(text = label, style = textStyle) },
                    modifier = Modifier,
                )
            }
        }
    }
}
