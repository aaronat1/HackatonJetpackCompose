package com.aaronat1.hackaton.ui.screens.register

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.aaronat1.hackaton.R

@Composable
fun PasswordVisibilityIcon(showPassword: Boolean, setShowPassword: (Boolean) -> Unit) {
    IconButton(
            onClick = { setShowPassword(!showPassword) }
    ) {
        if (showPassword) {
            Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = stringResource(id = R.string.hide_password)
            )
        } else {
            Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = stringResource(id = R.string.show_password)
            )
        }
    }
}