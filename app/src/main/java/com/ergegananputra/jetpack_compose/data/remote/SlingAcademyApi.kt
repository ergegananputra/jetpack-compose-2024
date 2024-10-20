package com.ergegananputra.jetpack_compose.data.remote

import com.ergegananputra.jetpack_compose.domain.entities.remote.response.SlingAcademyPhotosResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SlingAcademyApi {
    @GET("sample-data/photos")
    fun getPhotos(
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 10
    ) : Call<SlingAcademyPhotosResponse>
}