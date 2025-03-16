package com.utkarshsundaram.newsapp.data.repository

import com.utkarshsundaram.newsapp.data.model.Article
import javax.inject.Singleton

@Singleton
interface NewsRepository {
    suspend fun getNews(): List<Article>
}