package com.utkarshsundaram.newsapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.utkarshsundaram.newsapp.domain.GetNewsListUseCase
import javax.inject.Inject

class NewsViewModel @Inject constructor(
    private val getNewsListUseCase: GetNewsListUseCase
) : ViewModel() {

}