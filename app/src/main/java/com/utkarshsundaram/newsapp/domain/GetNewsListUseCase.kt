package com.utkarshsundaram.newsapp.domain

import com.utkarshsundaram.newsapp.data.model.Article
import com.utkarshsundaram.newsapp.data.model.Results

interface GetNewsListUseCase {
    suspend fun getNews(): Results<List<Article>>
}