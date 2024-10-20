package com.ergegananputra.jetpack_compose.ui.presentations.dashboard

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DashboardViewModel : ViewModel() {
    private val _state : MutableStateFlow<DashboardState> = MutableStateFlow(DashboardState())
    val state : StateFlow<DashboardState> = _state.asStateFlow()


    fun onCardInfoClicked() {
        _state.update { it.copy(isDialogConfirmOpen = true) }
    }

    fun onDialogDismissed() {
        _state.update { it.copy(isDialogConfirmOpen = false) }
    }
}