package com.abdelrahman.raafat.budget.tracker.ui.onboarding.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abdelrahman.raafat.budget.tracker.R
import com.abdelrahman.raafat.budget.tracker.ui.custom.PrimaryButton
import com.abdelrahman.raafat.budget.tracker.ui.custom.ProgressIndicator
import com.abdelrahman.raafat.budget.tracker.ui.onboarding.item.OnboardingItem
import com.abdelrahman.raafat.budget.tracker.ui.theme.BudgetTrackerOnBoardingTheme
import kotlinx.coroutines.launch

@Composable
fun OnboardingScreen(
    items: List<OnboardingItem>,
    onNextPage: () -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier =
            Modifier
                .padding(vertical = 32.dp)
                .wrapContentHeight(),
    ) {
        val pagerState =
            rememberPagerState(
                initialPage = 0,
                pageCount = {
                    items.size
                },
            )

        val coroutineScope = rememberCoroutineScope()

        val primaryButtonText = remember { mutableStateOf(("")) }
        primaryButtonText.value = stringResource(R.string.next)

        HorizontalPager(
            state = pagerState,
            modifier =
                Modifier
                    .fillMaxWidth()
                    .weight(1f),
        ) { page ->
            if (page == items.size - 1) {
                primaryButtonText.value = stringResource(R.string.start)
            }
            OnboardingContent(
                items[page],
                modifier =
                    Modifier
                        .fillMaxWidth(),
            )
        }

        Spacer(Modifier.height(15.dp))

        ProgressIndicator(
            pagerState = pagerState,
            size = 3,
            currentPage = 0,
        )

        Spacer(Modifier.height(15.dp))

        PrimaryButton(
            text = primaryButtonText.value,
            modifier = Modifier.padding(horizontal = 20.dp),
        ) {
            if (pagerState.currentPage == items.size - 1) {
                onNextPage.invoke()
            } else {
                coroutineScope.launch {
                    val nextPage =
                        (pagerState.currentPage + 1)
                            .coerceAtMost(items.size - 1)
                    pagerState.animateScrollToPage(nextPage)
                }
            }
        }
        Spacer(Modifier.height(5.dp))
        PrimaryButton(
            text = stringResource(R.string.skip),
            isTextButton = true,
            modifier = Modifier.padding(horizontal = 20.dp),
        ) {
            onNextPage.invoke()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewOnboardingScreen() {
    BudgetTrackerOnBoardingTheme {
        val onboardingList =
            listOf(
                OnboardingItem(
                    imageResId = R.drawable.ic_onboarding_1,
                    headline = "Gain total control\nof your money",
                    description = "Become your own money manager\nand make every cent count",
                ),
                OnboardingItem(
                    imageResId = R.drawable.ic_onboarding_2,
                    headline = "Track your expenses\nwith ease",
                    description = "Know where your money goes\nand make better financial decisions",
                ),
                OnboardingItem(
                    imageResId = R.drawable.ic_onboarding_3,
                    headline = "Planning ahead",
                    description = "Setup your budget for each category\nso you in control",
                ),
            )
        OnboardingScreen(onboardingList) {
        }
    }
}
