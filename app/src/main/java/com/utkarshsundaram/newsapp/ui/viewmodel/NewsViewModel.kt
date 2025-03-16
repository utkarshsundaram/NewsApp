package com.utkarshsundaram.newsapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.utkarshsundaram.newsapp.data.model.NewsState
import com.utkarshsundaram.newsapp.domain.GetNewsListUseCase
import com.utkarshsundaram.newsapp.domain.GetNewsListUseCaseImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewsViewModel @Inject constructor(
    private val getNewsListUseCase: GetNewsListUseCaseImpl
) : ViewModel() {
    private val _newsState = MutableStateFlow<NewsState>(NewsState.Loading)
    val newsState: StateFlow<NewsState> = _newsState

    internal fun loadNews() {
        viewModelScope.launch {
            when (val result = getNewsListUseCase.getNews()) {
                is NewsState.Loading -> {
                    _newsState.value = NewsState.Loading
                }

                is NewsState.Success -> {
                    _newsState.value = NewsState.Success(result.articles)
                }

                is NewsState.Failure -> {
                    _newsState.value = NewsState.Failure(result.message)
                }
            }
        }
    }
}