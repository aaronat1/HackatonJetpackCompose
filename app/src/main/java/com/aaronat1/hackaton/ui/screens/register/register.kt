package com.aaronat1.hackaton.ui.screens.register

import DatePickerView
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.ExperimentalComposeUiApi
import com.aaronat1.hackaton.R
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource

@ExperimentalComposeUiApi
@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun RegisterScreen(viewModel: RegisterViewModel = viewModel(), onRegister: () -> Unit) {
    val viewModelState by viewModel.state.collectAsState()
    LaunchedEffect(viewModelState.createdUser) {
        if (viewModelState.createdUser) {
            onRegister()
        }
    }

    val registerState = rememberRegisterState()
    RegisterForm(registerState, viewModel::registerUser)

}

@ExperimentalComposeUiApi
@Composable
private fun RegisterForm(registerState: RegisterState,
                         onSubmit: () -> Unit) {
    Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
    ) {
        Card (
                modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
        ) {
            Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.verticalScroll(registerState.scrollState)
            ) {
                Box(Modifier.height(16.dp))
                Icon(
                        tint = colorResource(id = R.color.purple_700),
                        imageVector = Icons.Default.Lock,
                        contentDescription = null,
                        modifier = Modifier
                                .width(60.dp)
                                .height(60.dp)
                )
                Box(Modifier.height(8.dp))
                DatePickerView(
                        context = LocalContext.current,
                        value = registerState.date.value,
                        setValue = { registerState.date.value = it }
                )
                Box(Modifier.height(16.dp))
                TermsAndConditions(registerState.terms.value) {
                    registerState.terms.value = it
                }
                Box(Modifier.height(16.dp))
                HacktonTextField(
                        value = registerState.email.value,
                        setValue = { registerState.email.value = it },
                        label = stringResource(R.string.email),
                        placeholder = stringResource(R.string.email),
                        keyboardType = KeyboardType.Email,
                        keyboardAction = ImeAction.Next,
                        keyboardActions = KeyboardActions() {registerState.focusRequester.requestFocus()} ,
                        leadingIcon = Icons.Default.Email,
                        focusRequester = registerState.focusRequester,
                        isError = registerState.isError.value && registerState.errorType.value == ErrorType.EMAIL)
                Box(Modifier.height(4.dp))
                HacktonTextField(
                        value = registerState.pass.value,
                        setValue = {registerState.pass.value = it},
                        label = stringResource(R.string.password),
                        placeholder = stringResource(R.string.password),
                        keyboardType = KeyboardType.Password,
                        keyboardAction = ImeAction.Done,
                        keyboardActions = KeyboardActions(onDone = { registerState.registerClicked() }) {
                            registerState.focusRequester.requestFocus()
                                                                                                        },
                        leadingIcon = Icons.Default.Lock,
                        trailingIcon = registerState.showPass.value,
                        showPassword = registerState.showPass.value,
                        setShowPassword = {registerState.showPass.value = it},
                        focusRequester = registerState.focusRequester,
                        isError = registerState.isError.value && registerState.errorType.value == ErrorType.PASSWORD)
                Box(Modifier.height(16.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Button(onClick = { registerState.clearClicked() }) {
                        Text(text = stringResource(R.string.clear))
                    }
                    Box(Modifier.width(16.dp))
                    Button(onClick = {
                        registerState.registerClicked()

                    }) {
                        Text(text = stringResource(R.string.register))
                    }
                }
                Box(Modifier.height(16.dp))
                if (registerState.isError.value) {
                    ErrorMessage(stringResource(registerState.errorType.value.message))
                }
                if (registerState.signUp.value) {
                    LocalSoftwareKeyboardController.current?.hide()
                    SignUpMessage()
                    onSubmit()
                }
                Box(Modifier.height(16.dp))
            }

        }
    }
}


@ExperimentalCoilApi
@ExperimentalMaterialApi
@Composable
fun RegisterDetailScreen(viewModel: RegisterDetailViewModel = viewModel()) {
    val state by viewModel.state.collectAsState()
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Congratulations!!", style = MaterialTheme.typography.h3)
    }
}