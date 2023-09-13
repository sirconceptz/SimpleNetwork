package com.hermanowicz.simplenetwork.ui.nav.userList.ui

import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.hermanowicz.simplenetwork.components.cards.SingleUserItemCard

@Composable
fun UserListScreen(
    onClickSingleUser: (Int) -> Unit
) {
    val viewModel: UserListViewModel = hiltViewModel()
    val state by viewModel.state.collectAsState()

    if(state.currentToast.isNotEmpty()) {
        Toast.makeText(LocalContext.current, state.currentToast, Toast.LENGTH_LONG).show()
        viewModel.updateCurrentToast("")
    }

    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(all = 8.dp)
    ) {
        item {
            Button(onClick = { viewModel.registerTestUser() }) {
                Text("Register test user")
            }
        }
        item {
            Text("User list", fontSize = 20.sp)
        }
        items(state.userList) { user ->
            SingleUserItemCard(user = user, onClickUser = { onClickSingleUser(it) })
        }
    }
}