package com.example.project2.Model

data class Photo(
    val id: String,          // Unique photo identifier
    val author: String,      // Author of the photo
    val width: Int,          // Image width
    val height: Int,         // Image height
    val download_url: String // URL to download the photo
)
