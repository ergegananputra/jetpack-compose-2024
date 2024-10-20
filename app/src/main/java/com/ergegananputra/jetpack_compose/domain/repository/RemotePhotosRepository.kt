package com.ergegananputra.jetpack_compose.domain.repository

interface RemotePhotosRepository {

    suspend fun fetchPhotos(page: Int, limit: Int = 10)

}