package com.utkarshsundaram.newsapp.domain

import com.utkarshsundaram.newsapp.data.model.Article
import com.utkarshsundaram.newsapp.data.model.Results
import com.utkarshsundaram.newsapp.data.repository.NewsRepository
import javax.inject.Inject

class GetNewsListUseCaseImpl @Inject constructor(private val repository: NewsRepository) :GetNewsListUseCase {
    override suspend fun getNews(): Results<List<Article>> {
        return try {
            val articles = repository.getNews()
            if(articles.isNotEmpty()){
                Results.Success(articles)
            } else {
                Results.Failure("Empty Article")
            }

        }  catch (e: Exception) {
            Results.Failure("Unknown error")
        }
    }

}