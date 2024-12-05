package com.abdelrahman.raafat.budget.tracker.ui.custom

import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.abdelrahman.raafat.budget.tracker.R
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppColors

@Suppress("FunctionName")
@Composable
fun BTFAB(
    showClose: Boolean,
    onFabClick: () -> Unit,
) {
    FloatingActionButton(
        shape = CircleShape,
        elevation = FloatingActionButtonDefaults.elevation(0.dp),
        onClick = {
            onFabClick.invoke()
        },
        containerColor = AppColors.PrimaryLight,
        content = {
            Icon(
                imageVector =
                    if (showClose) {
                        Icons.Default.Close
                    } else {
                        Icons.Default.Add
                    },
                contentDescription = stringResource(R.string.add_expense),
                modifier = Modifier.size(30.dp),
            )
        },
        modifier =
            Modifier
                .offset(y = 70.dp)
                .size(70.dp),
    )
}
