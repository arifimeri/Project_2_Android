

package com.example.project2.api

import com.example.project2.Model.Photo
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {

    @GET("v2/list")
    suspend fun getRandomPhotos(
        @Query("limit") limit: Int,
        @Query("page") page: Int
    ): List<Photo>

    @GET("id/{id}/download")
    suspend fun getPhotoById(@Path("id") photoId: String): String
}
