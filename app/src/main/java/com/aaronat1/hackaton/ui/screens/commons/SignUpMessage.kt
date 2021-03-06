package com.aaronat1.hackaton.ui.screens.register

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.aaronat1.hackaton.R

@Composable
fun SignUpMessage(modifier: Modifier = Modifier,) {
    Text(
        text = stringResource(R.string.signup),
        color = Color.Green,
        style = MaterialTheme.typography.caption,
        modifier = modifier
    )
}