package com.utkarshsundaram.newsapp.data.repository

import com.utkarshsundaram.newsapp.data.model.Article

interface NewsRepository {
    suspend fun getNews(): List<Article>
}