package com.hermanowicz.simplenetwork.ui.nav.userList.state

import com.hermanowicz.simplenetwork.data.model.User


data class UserListState(
    val userList: List<User> = emptyList()
)