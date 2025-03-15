package com.utkarshsundaram.newsapp.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import com.utkarshsundaram.newsapp.application.NewsApp
import com.utkarshsundaram.newsapp.di.component.DaggerAppComponent
import com.utkarshsundaram.newsapp.di.module.ActivityModule
import com.utkarshsundaram.newsapp.ui.viewmodel.NewsViewModel
import javax.inject.Inject

class NewsListActivity : ComponentActivity() {
    @Inject
    private lateinit var newsViewModel: NewsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        injectDependencies()
}
    private fun injectDependencies() {
        DaggerAppComponent.builder()
            .applicationComponent((application as NewsApp).applicationComponent)
            .activityModule(ActivityModule(this)).build().inject(this)
    }

}