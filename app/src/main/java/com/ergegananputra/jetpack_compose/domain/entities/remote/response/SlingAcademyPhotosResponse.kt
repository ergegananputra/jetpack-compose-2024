package com.ergegananputra.jetpack_compose.domain.entities.remote.response

import com.ergegananputra.jetpack_compose.domain.entities.base.PhotosInterface
import com.google.gson.annotations.SerializedName

class SlingAcademyPhotosResponse {
    var success : Boolean = false

    @SerializedName("total_photos")
    var totalPhotos : Int = 0

    var message : String = ""
    var offset : Int = 0
    var limit : Int = 0
    var photos : List<PhotoResponse> = listOf()
}