package com.utkarshsundaram.newsapp.domain

import com.utkarshsundaram.newsapp.data.model.NewsState
import com.utkarshsundaram.newsapp.data.repository.NewsRepository
import javax.inject.Inject

class GetNewsListUseCaseImpl @Inject constructor(
    private val repository: NewsRepository
) :GetNewsListUseCase {
    override suspend fun getNews(): NewsState {
        return try {
            val articles = repository.getNews()
            if(articles.isNotEmpty()){
                NewsState.Success(articles)
            } else {
                NewsState.Failure("Empty Article")
            }

        }  catch (e: Exception) {
            NewsState.Failure("Unknown error")
        }
    }

}