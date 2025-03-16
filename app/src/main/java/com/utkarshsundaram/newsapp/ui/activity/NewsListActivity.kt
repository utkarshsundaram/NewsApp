package com.utkarshsundaram.newsapp.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.utkarshsundaram.newsapp.application.NewsApp
import com.utkarshsundaram.newsapp.data.model.NewsState
import com.utkarshsundaram.newsapp.di.component.DaggerActivityComponent
import com.utkarshsundaram.newsapp.di.module.ActivityModule
import com.utkarshsundaram.newsapp.ui.screen.NewsListScreen
import com.utkarshsundaram.newsapp.ui.viewmodel.NewsViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewsListActivity : ComponentActivity() {
    @Inject
    lateinit var newsViewModel: NewsViewModel
    private lateinit var newsState: State<NewsState>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        injectDependencies()
        lifecycleScope.launch {
            newsViewModel.loadNews()
        }
        setContent {
            NewsList()
        }
}
    @Composable
    private fun NewsList() {
        newsState = newsViewModel.newsState.collectAsStateWithLifecycle()
        when (newsState.value) {
           is NewsState.Loading ->{
               CircularProgressIndicator()
           }
            is NewsState.Success -> {
                val articles = (newsState.value as NewsState.Success).articles
                NewsListScreen(articles)
            }
            is NewsState.Failure -> {
                val message = (newsState.value as NewsState.Failure).message
                Text(text = "Error: $message")
            }
        }
    }

    private fun injectDependencies() {
        DaggerActivityComponent.builder()
            .applicationComponent((application as NewsApp).applicationComponent)
            .activityModule(ActivityModule(this)).build().inject(this)
    }

}