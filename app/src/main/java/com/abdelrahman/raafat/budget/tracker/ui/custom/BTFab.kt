package com.abdelrahman.raafat.budget.tracker.ui.custom

import androidx.annotation.DrawableRes
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Suppress("FunctionName")
@Composable
fun BTFab(
    fabColor: Color,
    @DrawableRes iconResID: Int,
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
                painter = painterResource(iconResID),
                contentDescription = contentDescription,
                modifier = iconModifier,
                tint = Color.Unspecified,
            )
        },
        modifier = fabModifier,
    )
}
