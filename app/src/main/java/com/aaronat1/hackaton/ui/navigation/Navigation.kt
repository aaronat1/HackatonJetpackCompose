package com.aaronat1.hackaton.ui.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import coil.annotation.ExperimentalCoilApi
import com.aaronat1.hackaton.ui.screens.register.RegisterDetailScreen
import com.aaronat1.hackaton.ui.screens.register.RegisterScreen

@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun Navigation(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Feature.REGISTER.route
    ) {
        registerNav(navController)
    }
}

@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@ExperimentalCoilApi
@ExperimentalFoundationApi
private fun NavGraphBuilder.registerNav(navController: NavController) {
    navigation(
        startDestination = NavCommand.ContentType(Feature.REGISTER).route,
        route = Feature.REGISTER.route
    ) {
        composable(NavCommand.ContentType(Feature.REGISTER)) {
            RegisterScreen(onRegister = {
                navController.navigate(
                    NavCommand.ContentTypeDetail(Feature.REGISTER).createRoute(0)
                )
                }
            )
        }
        composable(NavCommand.ContentTypeDetail(Feature.REGISTER)) {
            RegisterDetailScreen()
        }

    }
}

private fun NavGraphBuilder.composable(
    navItem: NavCommand,
    content: @Composable (NavBackStackEntry) -> Unit
) {
    composable(
        route = navItem.route,
        arguments = navItem.args
    ) {
        content(it)
    }
}