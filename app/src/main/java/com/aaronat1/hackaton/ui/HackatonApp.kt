package com.aaronat1.hackaton.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import coil.annotation.ExperimentalCoilApi
import com.aaronat1.hackaton.R
import com.aaronat1.hackaton.ui.navigation.*
import com.aaronat1.hackaton.ui.theme.HackatonTheme

@ExperimentalComposeUiApi
@ExperimentalCoilApi
@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun HackathonApp() {
    val appState =  rememberHackatonAppState()

    HackatonScreen {
        Scaffold (
            topBar = {
                TopAppBar(
                    title = { Text(stringResource(R.string.app_name)) },
                    navigationIcon = { AppBarIcon(Icons.Default.AccountCircle, {}) },
                )
            },
            scaffoldState = appState.scaffoldState
        ) { padding ->
            Box(modifier = Modifier.padding(padding)) {
                Navigation(appState.navController)
            }
        }
    }
}

@Composable
fun HackatonScreen(content: @Composable () -> Unit) {
    HackatonTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}
