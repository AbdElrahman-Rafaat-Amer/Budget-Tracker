package com.abdelrahman.raafat.budget.tracker.ui.onboarding

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.abdelrahman.raafat.budget.tracker.MainActivity
import com.abdelrahman.raafat.budget.tracker.ui.onboarding.ui.OnboardingScreen
import com.abdelrahman.raafat.budget.tracker.ui.theme.BudgetTrackerTheme

class OnBoardingActivity : ComponentActivity() {
    private val viewModel: OnboardingViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BudgetTrackerTheme {
                OnboardingScreen(viewModel.onboardingList) {
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    BudgetTrackerTheme {
        OnBoardingActivity()
    }
}
