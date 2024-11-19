package com.abdelrahman.raafat.budget.tracker.ui.onboarding.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abdelrahman.raafat.budget.tracker.R
import com.abdelrahman.raafat.budget.tracker.ui.onboarding.item.OnboardingItem
import com.abdelrahman.raafat.budget.tracker.ui.theme.AppColors
import com.abdelrahman.raafat.budget.tracker.ui.theme.BudgetTrackerTheme

@Composable
fun OnboardingContent(
    onboardingItem: OnboardingItem,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(onboardingItem.imageResId),
            contentDescription = null,
        )

        Spacer(Modifier.height(20.dp))

        Text(
            text = onboardingItem.headline,
            style = MaterialTheme.typography.headlineMedium,
            color = AppColors.TextPrimary,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            textAlign = TextAlign.Center,
        )

        Spacer(Modifier.height(10.dp))

        Text(
            text = onboardingItem.description,
            color = AppColors.TextSecondary,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            lineHeight = 20.sp,
            textAlign = TextAlign.Center,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewOnboardingScreen() {
    BudgetTrackerTheme {
        OnboardingContent(
            onboardingItem =
                OnboardingItem(
                    imageResId = R.drawable.ic_onboarding_1,
                    headline = "Gain total control\nof your money",
                    description = "Become your own money manager\nand make every cent count",
                ),
        )
    }
}
