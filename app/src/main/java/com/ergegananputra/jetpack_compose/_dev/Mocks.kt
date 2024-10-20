package com.ergegananputra.jetpack_compose._dev

import com.ergegananputra.jetpack_compose.domain.entities.room.Photo
import com.ergegananputra.jetpack_compose.domain.repository.PhotosRepository
import kotlinx.coroutines.flow.Flow

object Mocks {
    val photosRepository = object : PhotosRepository {
        override fun getPhotos(): Flow<List<Photo>> {
            TODO("Not yet implemented")
        }

        override suspend fun upsertPhoto(photo: Photo) {
            TODO("Not yet implemented")
        }

        override suspend fun deletePhoto(photo: Photo) {
            TODO("Not yet implemented")
        }

        override suspend fun fetchPhotos(page: Int, limit: Int) {
            TODO("Not yet implemented")
        }
    }

}