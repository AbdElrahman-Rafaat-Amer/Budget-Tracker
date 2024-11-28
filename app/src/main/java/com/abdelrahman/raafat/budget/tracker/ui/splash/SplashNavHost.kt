package com.abdelrahman.raafat.budget.tracker.ui.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.abdelrahman.raafat.budget.tracker.PreferencesManager

@Suppress("FunctionName")
@Composable
fun SplashNavHost(
    preferencesManager: PreferencesManager,
    goToNextScreen: () -> Unit,
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") {
            SplashScreen {
                LaunchedEffect(Unit) {
                    // Fetch the pin value from PreferencesManager
                    val shouldShowPin = preferencesManager.getPin().isNotEmpty()
                    if (shouldShowPin) {
                        navController.navigate("pin")
                    } else {
                        goToNextScreen.invoke()
                    }
                }
            }
        }
        composable("pin") {
            PinScreen {
                goToNextScreen.invoke()
            }
        }
    }
}
