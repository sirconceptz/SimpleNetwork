package com.hermanowicz.simplenetwork.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hermanowicz.simplenetwork.ui.nav.singleUser.SingleUserRoute


@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    Surface(color = MaterialTheme.colorScheme.background) {
        NavHost(
            navController = navController,
            startDestination = AppScreens.UserList.route
        ) {
            composable(route = AppScreens.SingleUser.route) {
                SingleUserRoute()
            }
            composable(route = AppScreens.UserList.route) {
                SingleUserRoute()
            }
        }
    }
}