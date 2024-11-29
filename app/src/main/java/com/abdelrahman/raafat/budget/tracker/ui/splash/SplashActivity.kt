package com.abdelrahman.raafat.budget.tracker.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.abdelrahman.raafat.budget.tracker.MainActivity
import com.abdelrahman.raafat.budget.tracker.PreferencesManager
import com.abdelrahman.raafat.budget.tracker.ui.onboarding.OnBoardingActivity
import com.abdelrahman.raafat.budget.tracker.ui.theme.BudgetTrackerTheme
import kotlinx.coroutines.launch

class SplashActivity : ComponentActivity() {
    private val splashViewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BudgetTrackerTheme {
                SplashNavHost(splashViewModel) {
                    navigateToNextScreen()
                }
            }
        }
    }

    private fun navigateToNextScreen() {
        lifecycleScope.launch {
            val showOnboarding = PreferencesManager(application.baseContext).getShowOnboarding()
            if (showOnboarding) {
                startActivity(Intent(this@SplashActivity, OnBoardingActivity::class.java))
            } else {
                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            }
            finish()
        }
    }
}

@Suppress("FunctionName")
@Preview(showBackground = true)
@Composable
private fun SplashScreenPreview() {
    BudgetTrackerTheme {
        SplashScreen {}
    }
}
