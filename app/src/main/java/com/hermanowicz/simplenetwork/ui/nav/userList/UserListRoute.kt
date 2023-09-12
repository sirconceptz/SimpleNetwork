package com.hermanowicz.simplenetwork.ui.nav.userList

import androidx.compose.runtime.Composable
import com.hermanowicz.simplenetwork.ui.nav.userList.ui.UserListScreen

@Composable
fun UserListRoute(
    onClickSingleUser: (Int) -> Unit
) {
    UserListScreen(onClickSingleUser = onClickSingleUser)
}