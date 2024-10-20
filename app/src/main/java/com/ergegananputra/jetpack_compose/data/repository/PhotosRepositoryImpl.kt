package com.ergegananputra.jetpack_compose.data.repository

import android.util.Log
import com.ergegananputra.jetpack_compose.data.remote.SlingAcademyApi
import com.ergegananputra.jetpack_compose.domain.dao.PhotoDao
import com.ergegananputra.jetpack_compose.domain.entities.room.Photo
import com.ergegananputra.jetpack_compose.domain.repository.PhotosRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PhotosRepositoryImpl @Inject constructor(
    private val photoDao: PhotoDao,
    private val api: SlingAcademyApi
) : PhotosRepository {

    override fun getPhotos(): Flow<List<Photo>> {
        return photoDao.getAllPhotosOrderedByTimestampDesc()
    }

    override suspend fun upsertPhoto(photo: Photo) {
        return photoDao.upsert(photo.copy(timestamp = System.currentTimeMillis()))
    }

    override suspend fun deletePhoto(photo: Photo) {
        return photoDao.delete(photo)
    }

    override suspend fun fetchPhotos(page: Int, limit: Int) {
        val photosResponse = api
            .getPhotos(
                page = page,
                limit = limit
            )
            .execute()

        if (photosResponse.isSuccessful.not()) {
            Log.e(this::class.simpleName, "FetchPhotos - Response is not successful")
            return
        }

        val photos = photosResponse.body()?.photos ?: run {
            Log.e(this::class.simpleName, "FetchPhotos - Response body is null")
            return
        }

        photos.forEach {
            upsertPhoto(
                Photo(
                    id = it.id,
                    user = it.user,
                    title = it.title,
                    description = it.description,
                    url = it.url,
                )
            )
        }
    }
}