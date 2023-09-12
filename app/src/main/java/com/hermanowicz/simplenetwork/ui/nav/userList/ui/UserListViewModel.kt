package com.hermanowicz.simplenetwork.ui.nav.userList.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hermanowicz.simplenetwork.domain.FetchUserListUseCase
import com.hermanowicz.simplenetwork.ui.nav.userList.state.UserListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val fetchUserListUseCase: FetchUserListUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(UserListState())
    var state: StateFlow<UserListState> = _state.asStateFlow()

    init {
        updateUserListState()
    }

    private fun updateUserListState() {
        viewModelScope.launch(Dispatchers.IO) {
            val userList = fetchUserListUseCase()
            _state.update {
                it.copy(
                    userList = userList
                )
            }
        }
    }
}