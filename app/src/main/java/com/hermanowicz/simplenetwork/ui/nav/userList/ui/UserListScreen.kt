package com.hermanowicz.simplenetwork.ui.nav.userList.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@Composable
fun UserListScreen() {
    val viewModel: UserListViewModel = hiltViewModel()
    val state by viewModel.state.collectAsState()

    LazyColumn {
        item {
            Text("User list")
        }
        items(state.userList) {

        }
    }
}