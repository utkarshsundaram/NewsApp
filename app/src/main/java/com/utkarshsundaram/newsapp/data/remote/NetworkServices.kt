package com.utkarshsundaram.newsapp.data.remote

import com.utkarshsundaram.newsapp.data.model.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface NetworkServices {
    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country: String = "us"
    ): Response<NewsResponse>
}