package com.abdelrahman.raafat.budget.tracker.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppColors
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppTextStyles
import com.abdelrahman.raafat.budget.tracker.ui.theme.BudgetTrackerTheme

@Suppress("FunctionName")
@Composable
fun BottomNavigationBar(navController: NavController) {
    val items =
        listOf(
            BTBottomNavItem.Dashboard,
            BTBottomNavItem.Transaction,
            BTBottomNavItem.AddExpenses,
            BTBottomNavItem.Budget,
            BTBottomNavItem.Profile,
        )

    Box(
        modifier =
            Modifier.graphicsLayer {
                clip = true
                shape = BTBarShape()
            },
    ) {
        NavigationBar(
            containerColor = AppColors.BottomNavigationColor,
        ) {
            val currentRoute =
                navController
                    .currentBackStackEntryAsState()
                    .value
                    ?.destination
                    ?.route ?: BTBottomNavItem.Dashboard.route

            items.forEach { item ->
                NavigationBarItem(
                    icon = {
                        Icon(
                            painterResource(item.iconResId),
                            contentDescription = stringResource(item.titleResId),
                            modifier = Modifier.size(24.dp),
                        )
                    },
                    label = {
                        Text(
                            text = stringResource(item.titleResId),
                            style =
                                AppTextStyles.textStyle10SPNormal.copy(
                                    color = Color.Unspecified,
                                ),
                        )
                    },
                    selected = currentRoute == item.route,
                    onClick = {
                        if (item.route != navController.currentDestination?.route) {
                            navController.navigate(item.route) {
                                popUpTo(navController.graph.startDestinationId) { saveState = true }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    },
                    enabled = item.route != BTBottomNavItem.AddExpenses.route,
                    colors =
                        NavigationBarItemDefaults.colors(
                            selectedIconColor = AppColors.PrimaryLight,
                            selectedTextColor = AppColors.PrimaryLight,
                            unselectedIconColor = AppColors.Gray,
                            unselectedTextColor = AppColors.Gray,
                            disabledIconColor = AppColors.Transparent,
                            disabledTextColor = AppColors.Transparent,
                            indicatorColor = AppColors.Transparent,
                        ),
                )
            }
        }
    }
}

@Suppress("FunctionName")
@Preview
@Composable
private fun BottomNavigationBarPreview() {
    BudgetTrackerTheme {
        val navController = rememberNavController()
        BottomNavigationBar(navController)
    }
}
