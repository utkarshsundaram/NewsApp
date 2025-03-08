package com.utkarshsundaram.newsapp.di.module

import android.content.Context
import com.utkarshsundaram.newsapp.application.NewsApp
import com.utkarshsundaram.newsapp.data.remote.NetworkServices
import com.utkarshsundaram.newsapp.data.remote.NewsAppInterceptors
import com.utkarshsundaram.newsapp.di.qualifiers.ApplicationContext
import com.utkarshsundaram.newsapp.di.qualifiers.BaseUrl
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApplicationModule(private val application:NewsApp) {
    @ApplicationContext
    @Provides
    fun provideContext(): Context {
        return application
    }

    @BaseUrl
    @Provides
    fun provideBaseUrl(): String = "https://newsapi.org/v2/"

    @Provides
    @Singleton
    fun provideGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    @Singleton
    fun provideAPIInterceptors():NewsAppInterceptors = NewsAppInterceptors()

    @Provides
    @Singleton
    fun provideOKHTTPClient(appInterceptors: NewsAppInterceptors):OkHttpClient{
        return OkHttpClient.Builder()
            .addInterceptor(appInterceptors)
            .build()
    }
    @Provides
    fun provideNewsApi(
        @BaseUrl baseUrl: String,
        gsonConverterFactory: GsonConverterFactory,
        okHttpClient: OkHttpClient
    ): NetworkServices {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
            .create(NetworkServices::class.java)
    }
}