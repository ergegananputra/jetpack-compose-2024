package com.ergegananputra.jetpack_compose.domain.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.ergegananputra.jetpack_compose.domain.entities.room.Photo
import kotlinx.coroutines.flow.Flow

@Dao
interface PhotoDao {

    @Upsert
    suspend fun upsert(photo: Photo)

    @Delete
    suspend fun delete(photo: Photo)

    @Query("SELECT * FROM photos ORDER BY timestamp DESC")
    fun getAllPhotosOrderedByTimestampDesc(): Flow<List<Photo>>
}