package com.utkarshsundaram.newsapp.data.repository

import com.utkarshsundaram.newsapp.data.model.Article
import com.utkarshsundaram.newsapp.data.remote.NetworkServices
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(private val networkServices: NetworkServices):NewsRepository {
    override suspend fun getNews(): List<Article> {
        val response = networkServices.getTopHeadlines()
        return if (response.isSuccessful) response.body()?.articles?: emptyList() else emptyList()
    }
}