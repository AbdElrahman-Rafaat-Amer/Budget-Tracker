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

    NavHost(navController = navController, startDestination = SplashNavRoute.Splash.route) {
        composable(SplashNavRoute.Splash.route) {
            SplashScreen {
                LaunchedEffect(Unit) {
                    // Fetch the pin value from PreferencesManager
                    if (viewModel.pinValue.isNotEmpty()) {
                        navController.navigate(SplashNavRoute.Pin.route) {
                            popUpTo(SplashNavRoute.Splash.route) { inclusive = true }
                        }
                    } else {
                        goToNextScreen.invoke()
                    }
                }
            }
        }
        composable(SplashNavRoute.Pin.route) {
            PinScreen(viewModel, isFirstTime = false) {
                goToNextScreen.invoke()
            }
        }
    }
}

sealed class SplashNavRoute(
    val route: String,
) {
    data object Splash : SplashNavRoute("splash")

    data object Pin : SplashNavRoute("pin")
}
