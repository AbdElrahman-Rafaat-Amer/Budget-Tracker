package com.abdelrahman.raafat.budget.tracker.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BTBottomNavItem(
    val route: String,
    val icon: ImageVector,
    val title: String,
) {
    data object Dashboard : BTBottomNavItem("dashboard", Icons.Default.Home, "Dashboard")

    data object Transaction : BTBottomNavItem("transaction", Icons.Default.Search, "Transaction")

    data object Budget : BTBottomNavItem("budget", Icons.Default.Search, "Budget")

    data object Profile : BTBottomNavItem("profile", Icons.Default.Person, "Profile")
}
