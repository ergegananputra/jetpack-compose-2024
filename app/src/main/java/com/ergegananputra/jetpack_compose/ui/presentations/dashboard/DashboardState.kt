package com.ergegananputra.jetpack_compose.ui.presentations.dashboard

import com.ergegananputra.jetpack_compose.domain.entities.room.Photo

data class DashboardState(
    val isDialogConfirmOpen: Boolean = false,
    val photos: List<Photo> = emptyList()
)
