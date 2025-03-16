package com.utkarshsundaram.newsapp.di.component

import android.content.Context
import com.utkarshsundaram.newsapp.application.NewsApp
import com.utkarshsundaram.newsapp.data.remote.NetworkServices
import com.utkarshsundaram.newsapp.data.repository.NewsRepository
import com.utkarshsundaram.newsapp.di.module.ApplicationModule
import com.utkarshsundaram.newsapp.di.qualifiers.ApplicationContext
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun inject(application: NewsApp)

    @ApplicationContext
    fun getContext(): Context

    @Singleton
    fun getNetworkServices(): NetworkServices

    fun getNewsRepository(): NewsRepository
}