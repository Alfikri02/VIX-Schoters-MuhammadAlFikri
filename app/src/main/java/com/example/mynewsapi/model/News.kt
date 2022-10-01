package com.example.mynewsapi.model

import com.google.gson.annotations.SerializedName

data class News(
    @SerializedName("articles")
    val news: List<Article>,
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int
)
