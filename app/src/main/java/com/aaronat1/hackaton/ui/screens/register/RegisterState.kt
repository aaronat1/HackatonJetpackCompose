package com.aaronat1.hackaton.ui.screens.register

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.focus.FocusRequester
import com.aaronat1.hackaton.R
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun rememberRegisterState(
    scrollState: ScrollState = rememberScrollState(),
    focusRequester: FocusRequester = remember { FocusRequester() },
    email: MutableState<String> = rememberSaveable { mutableStateOf("") },
    pass: MutableState<String> = rememberSaveable { mutableStateOf("") },
    date: MutableState<String> = rememberSaveable { mutableStateOf("") },
    showPass: MutableState<Boolean> = rememberSaveable { mutableStateOf(true) },
    terms: MutableState<Boolean> = rememberSaveable { mutableStateOf(false) },
    isError: MutableState<Boolean> = rememberSaveable { mutableStateOf(false) },
    errorType: MutableState<ErrorType> = remember { mutableStateOf(ErrorType.NONE) },
    signUp: MutableState<Boolean> = rememberSaveable { mutableStateOf(false) },
) = remember{ RegisterState(
        scrollState,
        focusRequester,
        email,
        pass,
        date,
        showPass,
        terms,
        isError,
        errorType,
        signUp) }

class RegisterState(
        val scrollState: ScrollState,
        val focusRequester: FocusRequester,
        val email: MutableState<String>,
        val pass: MutableState<String>,
        val date: MutableState<String>,
        val showPass: MutableState<Boolean>,
        val terms: MutableState<Boolean>,
        val isError: MutableState<Boolean>,
        val errorType: MutableState<ErrorType>,
        val signUp: MutableState<Boolean>
) {


    fun registerClicked() = when {
        date.value == ""  -> {
            isError.value = true
            errorType.value = ErrorType.AGE
        }
        LocalDate.parse(date.value, DateTimeFormatter.ofPattern("dd-MM-yyyy"))
            .isAfter(LocalDate.now().minusYears(18)) -> {
            isError.value = true
            errorType.value = ErrorType.AGE
        }
        !terms.value -> {
            isError.value = true
            errorType.value = ErrorType.TERMS
        }
        email.value.length < 3 || !email.value.contains('@') -> {
            isError.value = true
            errorType.value = ErrorType.EMAIL
        }
        pass.value.length < 6 -> {
            isError.value = true
            errorType.value = ErrorType.PASSWORD
        }
        else -> {
            isError.value = false
            signUp.value = true
            errorType.value = ErrorType.NONE
        }
    }

    fun clearClicked() {
        email.value = ""
        pass.value = ""
        terms.value = false
        date.value = ""
        isError.value = false
        errorType.value = ErrorType.NONE
        signUp.value = false
    }
}

enum class ErrorType(val message: Int) {
    NONE(-1),
    EMAIL(R.string.email_error),
    PASSWORD(R.string.pass_error),
    TERMS(R.string.terms_error),
    AGE(R.string.age_error)
}
