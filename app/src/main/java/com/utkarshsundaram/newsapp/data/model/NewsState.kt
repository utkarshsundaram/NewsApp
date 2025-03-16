package com.utkarshsundaram.newsapp.data.model

sealed class NewsState  {
    object Loading : NewsState()
    data class Success(val articles: List<Article>) : NewsState()
    data class Failure(val message: String) : NewsState()
}