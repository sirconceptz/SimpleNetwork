package com.hermanowicz.simplenetwork.ui.nav.singleUser.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hermanowicz.simplenetwork.domain.FetchUserByIdUseCase
import com.hermanowicz.simplenetwork.ui.nav.singleUser.state.SingleUserState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SingleUserViewModel @Inject constructor(
    private val fetchUserByIdUseCase: FetchUserByIdUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = MutableStateFlow(SingleUserState())
    var state: StateFlow<SingleUserState> = _state.asStateFlow()

    private val id: String = savedStateHandle["id"] ?: "-1"

    init {
        val parsedId = id.toInt()
        updateUserState(parsedId)
    }

    private fun updateUserState(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val user = fetchUserByIdUseCase(id)
            if (user != null) {
                _state.update {
                    it.copy(user = user)
                }
            }
        }
    }
}