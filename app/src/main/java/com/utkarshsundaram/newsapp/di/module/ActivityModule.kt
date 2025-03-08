package com.utkarshsundaram.newsapp.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import androidx.activity.ComponentActivity
import com.utkarshsundaram.newsapp.di.qualifiers.ActivityContext

@Module
class ActivityModule(private val activity: ComponentActivity) {
    @ActivityContext
    @Provides
    fun provideContext(): Context {
        return activity
    }
}