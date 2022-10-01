package com.example.mynewsapi.network

import com.example.mynewsapi.BuildConfig
import com.example.mynewsapi.model.News
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("everything?q=apple&apiKey=${BuildConfig.API_KEY}")
    fun getNews(): Call<News>
}