package com.hermanowicz.simplenetwork.ui.nav.userList.ui

import androidx.lifecycle.ViewModel
import com.hermanowicz.simplenetwork.ui.nav.userList.state.UserListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(

) : ViewModel() {
    private val _state = MutableStateFlow(UserListState())
    var state: StateFlow<UserListState> = _uiState.asStateFlow()


}