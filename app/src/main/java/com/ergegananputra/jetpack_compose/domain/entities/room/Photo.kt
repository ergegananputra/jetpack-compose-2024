package com.ergegananputra.jetpack_compose.domain.entities.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ergegananputra.jetpack_compose.domain.entities.base.PhotosInterface

@Entity(tableName = "photos")
data class Photo(
    @PrimaryKey(autoGenerate = true)
    override var id: Int = 0,
    override var title: String?,
    override var description: String?,
    override var user: String?,
    override var url: String?,
    var timestamp: Long = System.currentTimeMillis()
) : PhotosInterface<Int>