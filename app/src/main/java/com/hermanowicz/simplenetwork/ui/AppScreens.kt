package com.hermanowicz.simplenetwork.ui

sealed class AppScreens(
    val route: String
) {
    object SingleUser : AppScreens("single_user")
    object UserList : AppScreens("user_list")
}