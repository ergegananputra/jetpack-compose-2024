package com.ergegananputra.jetpack_compose.ui.presentations.dashboard

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ergegananputra.jetpack_compose.domain.repository.PhotosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val photosRepository: PhotosRepository
) : ViewModel() {

    private val _photos = photosRepository
        .getPhotos()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    private val _state : MutableStateFlow<DashboardState> = MutableStateFlow(DashboardState())

    val state = combine(_photos, _state) { photos, state ->
        state.copy(
            photos = photos
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), DashboardState())


    fun onCardInfoClicked() {
        _state.update { it.copy(isDialogConfirmOpen = true) }
    }

    fun onDialogDismissed() {
        _state.update { it.copy(isDialogConfirmOpen = false) }
    }

    fun fetchPhotos() {
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("DashboardViewModel", "fetchPhotos")
            photosRepository.fetchPhotos(1, 10)
        }
    }
}