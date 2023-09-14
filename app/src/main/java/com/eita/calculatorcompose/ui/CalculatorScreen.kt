package com.eita.calculatorcompose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eita.calculatorcompose.ui.theme.CalculatorComposeTheme

@Composable
fun CalculatorScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        val displayText = remember { mutableStateOf("0") }

        DisplayScreen(text = displayText.value)
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            content = {
                items(11,
                    span = {
                        GridItemSpan(if (it == 10) 2 else 1)
                    }) {
                    val buttonText = (10 - it).toString()
                    Button(
                        onClick = { displayText.value = displayText.value + buttonText },
                        modifier = Modifier.padding(5.dp)
                    ) {
                        Text(buttonText)
                    }
                }
            }
        )
    }
}

@Composable
fun DisplayScreen(text: String) {
    Text(
        text = text,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        textAlign = TextAlign.Right,
        fontSize = 30.sp,
        modifier = Modifier
            .background(Color(30, 150, 30))
            .fillMaxWidth()
            .padding(5.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun CalculatorScreenPreview() {
    CalculatorComposeTheme {
        CalculatorScreen()
    }
}