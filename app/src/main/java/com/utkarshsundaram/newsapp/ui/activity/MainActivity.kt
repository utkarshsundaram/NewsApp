package com.utkarshsundaram.newsapp.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import com.utkarshsundaram.newsapp.application.NewsApp
import com.utkarshsundaram.newsapp.di.component.DaggerAppComponent
import com.utkarshsundaram.newsapp.di.module.ActivityModule

class MainActivity : ComponentActivity() {
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