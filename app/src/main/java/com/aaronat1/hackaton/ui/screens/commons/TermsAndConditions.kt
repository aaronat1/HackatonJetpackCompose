package com.aaronat1.hackaton.ui.screens.register

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.aaronat1.hackaton.R

@Composable
fun TermsAndConditions(checked: Boolean, onCheckedChange : (Boolean) -> Unit) {
    Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable(
                    onClick = {
                        onCheckedChange(!checked)
                    }
            )
    ) {
        Text(
                text = stringResource(id = R.string.terms),
                style = MaterialTheme.typography.caption,
        )
        Box(Modifier.width(4.dp))
        Checkbox(
                checked = checked,
                onCheckedChange = onCheckedChange,
                modifier = Modifier.height(4.dp)
        )
    }
}