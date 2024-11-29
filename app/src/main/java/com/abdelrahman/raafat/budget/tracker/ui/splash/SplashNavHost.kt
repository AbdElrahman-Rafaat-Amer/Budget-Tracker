package com.abdelrahman.raafat.budget.tracker.ui.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Suppress("FunctionName")
@Composable
fun SplashNavHost(
    viewModel: SplashViewModel,
    goToNextScreen: () -> Unit,
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") {
            SplashScreen {
                LaunchedEffect(Unit) {
                    // Fetch the pin value from PreferencesManager
                    if (viewModel.pinValue.isNotEmpty()) {
                        navController.navigate("pin") {
                            popUpTo("splash") { inclusive = true }
                        }
                    } else {
                        goToNextScreen.invoke()
                    }
                }
            }
        }
        composable("pin") {
            PinScreen(viewModel, isFirstTime = false) {
                goToNextScreen.invoke()
            }
        }
    }
}
