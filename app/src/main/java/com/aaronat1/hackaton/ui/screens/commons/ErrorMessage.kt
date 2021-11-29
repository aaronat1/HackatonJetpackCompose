package com.aaronat1.hackaton.ui.screens.register

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun ErrorMessage(messageError: String, modifier: Modifier = Modifier,) {
    Text(
        text = messageError,
        color = Color.Red,
        style = MaterialTheme.typography.caption,
        modifier = modifier
    )
}