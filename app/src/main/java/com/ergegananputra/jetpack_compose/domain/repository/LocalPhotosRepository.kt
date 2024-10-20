package com.ergegananputra.jetpack_compose.domain.repository

import com.ergegananputra.jetpack_compose.domain.entities.room.Photo
import kotlinx.coroutines.flow.Flow

interface LocalPhotosRepository {

    fun getPhotos() : Flow<List<Photo>>

    suspend fun upsertPhoto(photo: Photo)

    suspend fun deletePhoto(photo: Photo)
}