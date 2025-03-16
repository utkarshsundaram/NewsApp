package com.utkarshsundaram.newsapp.domain

import com.utkarshsundaram.newsapp.data.model.NewsState

interface GetNewsListUseCase {
    suspend fun getNews(): NewsState
}