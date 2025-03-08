package com.utkarshsundaram.newsapp.data.remote

import com.utkarshsundaram.newsapp.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Singleton

@Singleton
class NewsAppInterceptors : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("X-Api-Key", BuildConfig.NEWS_API_KEY)
            .build()
        return chain.proceed(request)
    }
}