package com.utkarshsundaram.newsapp.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModelProvider
import com.utkarshsundaram.newsapp.data.remote.NetworkServices
import com.utkarshsundaram.newsapp.data.repository.NewsRepository
import com.utkarshsundaram.newsapp.data.repository.NewsRepositoryImpl
import com.utkarshsundaram.newsapp.di.qualifiers.ActivityContext
import com.utkarshsundaram.newsapp.domain.GetNewsListUseCase
import com.utkarshsundaram.newsapp.domain.GetNewsListUseCaseImpl
import com.utkarshsundaram.newsapp.ui.base.ViewModelProviderFactory
import com.utkarshsundaram.newsapp.ui.viewmodel.NewsViewModel
import javax.inject.Singleton

@Module
class ActivityModule(private val activity: ComponentActivity) {
    @ActivityContext
    @Provides
    fun provideContext(): Context {
        return activity
    }
    @Provides
    fun provideGetNewsUseCase(repository: NewsRepository): GetNewsListUseCaseImpl {
        return GetNewsListUseCaseImpl(repository)
    }

    @Provides
    fun provideNewsViewModel(useCase: GetNewsListUseCaseImpl): NewsViewModel {
        return ViewModelProvider(activity,
            ViewModelProviderFactory(NewsViewModel::class) {
                NewsViewModel(useCase)
            })[NewsViewModel::class.java]
    }
}