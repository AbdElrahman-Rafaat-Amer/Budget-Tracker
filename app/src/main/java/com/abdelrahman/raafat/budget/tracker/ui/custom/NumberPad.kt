package com.abdelrahman.raafat.budget.tracker.ui.custom

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import com.abdelrahman.raafat.budget.tracker.R

@Composable
fun NumberPad(onNumberClick: (number: String?) -> Unit) {
    val keyboardNumbers: ArrayList<String> = arrayListOf()
    repeat(9) {
        keyboardNumbers.add((it + 1).toString())
    }
    keyboardNumbers.add("backspace button")
    keyboardNumbers.add("0")
    keyboardNumbers.add("")
    Column(
        verticalArrangement = Arrangement.spacedBy(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val newList = keyboardNumbers.chunked(3)
        newList.forEach {
            KeyboardRow(it) { clickedNumber ->
                onNumberClick(clickedNumber)
            }
        }
    }
}

@Suppress("FunctionName")
@Composable
private fun KeyboardRow(
    chunk: List<String>,
    onNumberClick: (number: String?) -> Unit,
) {
    val itemSize = 70.dp
    Row(
        horizontalArrangement = Arrangement.spacedBy(15.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        chunk.forEach {
            if (it.isEmpty()) {
                Spacer(Modifier.size(70.dp))
            } else if (it.isDigitsOnly()) {
                BTCustomIndicator(
                    color = MaterialTheme.colorScheme.primary,
                    size = itemSize,
                    text = it,
                    isClickable = true,
                ) { clickedNumber ->
                    onNumberClick(clickedNumber)
                }
            } else {
                Image(
                    painter = painterResource(R.drawable.ic_backspace),
                    contentDescription = stringResource(R.string.delete),
                    modifier =
                        Modifier
                            .size(itemSize)
                            .padding(10.dp)
                            .clickable { onNumberClick(null) },
                )
            }
        }
    }
}
