package com.abdelrahman.raafat.budget.tracker.ui.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.abdelrahman.raafat.budget.tracker.ScreensName

@Suppress("FunctionName")
@Composable
fun SplashNavHost(
    viewModel: SplashViewModel,
    goToNextScreen: () -> Unit,
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = ScreensName.Splash.route) {
        composable(ScreensName.Splash.route) {
            SplashScreen {
                LaunchedEffect(Unit) {
                    // Fetch the pin value from PreferencesManager
                    if (viewModel.pinValue.isNotEmpty()) {
                        navController.navigate(ScreensName.Pin.route) {
                            popUpTo(ScreensName.Splash.route) { inclusive = true }
                        }
                    } else {
                        goToNextScreen.invoke()
                    }
                }
            }
        }
        composable(ScreensName.Pin.route) {
            PinScreen(viewModel, isFirstTime = false) {
                goToNextScreen.invoke()
            }
        }
    }
}
