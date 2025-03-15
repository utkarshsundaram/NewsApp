package com.utkarshsundaram.newsapp.data.model

sealed class Results<out T> {
    data class Success<T>(val data: T) : Results<T>()
    data class Failure(val message: String) : Results<Nothing>()
}