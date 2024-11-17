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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.abdelrahman.raafat.budget.tracker.R
import com.abdelrahman.raafat.budget.tracker.ui.custom.CheckboxWithText
import com.abdelrahman.raafat.budget.tracker.ui.custom.PrimaryButton
import com.abdelrahman.raafat.budget.tracker.ui.custom.ProgressIndicator
import com.abdelrahman.raafat.budget.tracker.ui.onboarding.OnboardingViewModel
import kotlinx.coroutines.launch

@Composable
fun OnboardingScreen(
    viewModel: OnboardingViewModel,
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
        val onboardingList = viewModel.onboardingList

        val next = stringResource(R.string.next)
        val start = stringResource(R.string.start)
        val primaryButtonText = remember { mutableStateOf((next)) }

        var isLastItem by remember { mutableStateOf(false) }

        val pagerState =
            rememberPagerState(
                initialPage = 0,
                pageCount = {
                    onboardingList.size
                },
            )

        val coroutineScope = rememberCoroutineScope()

        // Listen for changes in the current page
        LaunchedEffect(pagerState.currentPage) {
            if (pagerState.currentPage >= onboardingList.size - 1) {
                primaryButtonText.value = start
                isLastItem = true
            } else {
                primaryButtonText.value = next
                isLastItem = false
            }
        }
        HorizontalPager(
            state = pagerState,
            modifier =
                Modifier
                    .fillMaxWidth()
                    .weight(1f),
        ) { page ->
            OnboardingContent(
                onboardingList[page],
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
            if (pagerState.currentPage == onboardingList.size - 1) {
                onNextPage.invoke()
            } else {
                coroutineScope.launch {
                    val nextPage =
                        (pagerState.currentPage + 1)
                            .coerceAtMost(onboardingList.size - 1)
                    pagerState.animateScrollToPage(nextPage)
                }
            }
        }
        Spacer(Modifier.height(5.dp))
        if (isLastItem) {
            CheckboxWithText(stringResource(R.string.show_onboarding)) {
                viewModel.saveShowOnboarding(it)
            }
        } else {
            PrimaryButton(
                text = stringResource(R.string.skip),
                isTextButton = true,
                modifier = Modifier.padding(horizontal = 20.dp),
            ) {
                onNextPage.invoke()
            }
        }
    }
}
