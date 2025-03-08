package com.utkarshsundaram.newsapp.application

import android.app.Application
import com.utkarshsundaram.newsapp.di.component.ApplicationComponent
import com.utkarshsundaram.newsapp.di.component.DaggerApplicationComponent
import com.utkarshsundaram.newsapp.di.module.ApplicationModule

class NewsApp : Application() {
     lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injectDependency()
    }

    private fun injectDependency() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }
}