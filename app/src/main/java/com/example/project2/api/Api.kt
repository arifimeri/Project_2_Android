package com.example.project2.api
import android.telecom.Call
import androidx.compose.ui.graphics.vector.Path
import com.example.project2.Model.Post
import com.example.project2.Model.User
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET("posts")
    suspend fun getPosts(): List<Post>

    @GET("users/{id}")
    suspend fun getUser(@Path("id") userId: Int): User
}
