package com.hermanowicz.simplenetwork.ui.nav.singleUser.ui

import androidx.lifecycle.ViewModel
import com.hermanowicz.simplenetwork.ui.nav.singleUser.state.SingleUserState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SingleUserViewModel @Inject constructor(

) : ViewModel() {
    private val _uiState = MutableStateFlow(SingleUserState())
    var uiState: StateFlow<SingleUserState> = _uiState.asStateFlow()


}