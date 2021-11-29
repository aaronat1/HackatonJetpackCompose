package com.aaronat1.hackaton.ui

import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope

@Composable
fun rememberHackatonAppState(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope()
) : HackatonAppState = remember(scaffoldState, navController, coroutineScope) {
    HackatonAppState(scaffoldState, navController ,coroutineScope)

}

class HackatonAppState(
    val scaffoldState: ScaffoldState,
    val navController: NavHostController,
    val coroutineScope: CoroutineScope
) {

}