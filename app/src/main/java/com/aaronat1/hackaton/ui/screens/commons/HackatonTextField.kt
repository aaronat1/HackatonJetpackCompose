package com.aaronat1.hackaton.ui.screens.register

import androidx.compose.foundation.background
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.aaronat1.hackaton.R

@Composable
fun HacktonTextField(
        value: String,
        setValue: (String) -> Unit,
        label: String = "",
        placeholder: String = "",
        keyboardType: KeyboardType = KeyboardType.Text,
        keyboardAction: ImeAction = ImeAction.Next,
        keyboardActions: KeyboardActions = KeyboardActions(),
        leadingIcon: ImageVector? = null,
        trailingIcon: Boolean? = null,
        showPassword: Boolean = false,
        setShowPassword: (Boolean) -> Unit = {},
        focusRequester: FocusRequester,
        isError: Boolean = false,
        modifier: Modifier = Modifier,
) {
    TextField(
            value = value,
            onValueChange = setValue,
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                    keyboardType = keyboardType,
                    imeAction = keyboardAction
            ),
            keyboardActions = keyboardActions,
            label = { Text(text = label) },
            placeholder = { Text(text = placeholder) },
            leadingIcon = {
                if (leadingIcon != null) {
                    HackatonIcon(leadingIcon)
                }
            },
            trailingIcon = {
                if (trailingIcon != null) {
                    PasswordVisibilityIcon(trailingIcon, setShowPassword)
                }
            },
            visualTransformation = if (!showPassword) VisualTransformation.None else PasswordVisualTransformation(),
            colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                    focusedIndicatorColor =  colorResource(id = R.color.purple_200),
                    unfocusedIndicatorColor = Color.Gray),
            isError = isError,
            modifier = modifier.background(color = Color.Transparent).focusRequester(focusRequester)
    )
}