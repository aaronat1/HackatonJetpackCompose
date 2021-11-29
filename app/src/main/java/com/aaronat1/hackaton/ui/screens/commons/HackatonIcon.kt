package com.aaronat1.hackaton.ui.screens.register

import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun HackatonIcon(imageVector: ImageVector, contentDescription: String = "", modifier: Modifier = Modifier,) {
    Icon(
        imageVector = imageVector,
        contentDescription = contentDescription,
        modifier = modifier
    )
}