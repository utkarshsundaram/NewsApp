package com.utkarshsundaram.newsapp.di.component

import com.utkarshsundaram.newsapp.di.module.ActivityModule
import com.utkarshsundaram.newsapp.di.scope.ActivityScope
import com.utkarshsundaram.newsapp.ui.activity.NewsListActivity
import dagger.Component

@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface AppComponent {
    fun inject(app: NewsListActivity)
}