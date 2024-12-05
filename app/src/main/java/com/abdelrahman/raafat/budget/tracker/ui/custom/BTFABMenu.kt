package com.abdelrahman.raafat.budget.tracker.ui.custom

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Suppress("FunctionName")
@Composable
fun BTFABMenu(
    onDismiss: () -> Unit,
    onIncomeClick: () -> Unit,
    onTransferClick: () -> Unit,
    onExpenseClick: () -> Unit,
) {
    Box(
        modifier = Modifier.padding(top = 80.dp, bottom = 15.dp),
    ) {
        // Floating buttons at the top
        Row(
            modifier =
                Modifier
                    .align(Alignment.Center),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            BTFAB2(
                fabColor = Color(0xFF4CAF50), // Green
                icon = Icons.Default.PlayArrow,
                contentDescription = "Income",
            ) {
                onDismiss()
                onIncomeClick()
            }

            BTFAB2(
                fabColor = Color(0xFF2196F3), // Blue
                icon = Icons.Default.Share,
                contentDescription = "Transfer",
                fabModifier = Modifier.offset(y = (-60).dp),
            ) {
                onDismiss()
                onTransferClick()
            }

            BTFAB2(
                fabColor = Color(0xFFF44336), // Red
                icon = Icons.Default.Settings,
                contentDescription = "Expense",
            ) {
                onDismiss()
                onExpenseClick()
            }
        }
    }
}

@Suppress("FunctionName")
@Composable
fun BTFAB2(
    fabColor: Color,
    icon: ImageVector,
    contentDescription: String,
    fabModifier: Modifier = Modifier,
    iconModifier: Modifier = Modifier,
    onFabClick: () -> Unit,
) {
    FloatingActionButton(
        shape = CircleShape,
        elevation = FloatingActionButtonDefaults.elevation(0.dp),
        onClick = {
            onFabClick.invoke()
        },
        containerColor = fabColor,
        content = {
            Icon(
                imageVector = icon,
                contentDescription = contentDescription,
                modifier = iconModifier,
            )
        },
        modifier = fabModifier,
    )
}

// @Composable
// fun CircularFloatingButton(
//    color: Color,
//    icon: ImageVector,
//    contentDescription: String,
//    modifier: Modifier = Modifier,
//    onClick: () -> Unit
// ) {
//    FloatingActionButton(
//        shape = CircleShape,
//        onClick = onClick,
//        containerColor = color,
//        modifier = modifier.size(56.dp)
//    ) {
//        Icon(
//            imageVector = icon,
//            contentDescription = contentDescription,
//            tint = Color.White
//        )
//    }
// }
