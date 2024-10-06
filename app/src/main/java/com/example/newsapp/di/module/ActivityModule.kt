package com.example.newsapp.di.module

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.example.newsapp.data.api.NetworkService
import com.example.newsapp.data.repository.TopHeadlineRepository
import com.example.newsapp.di.ActivityContext
import com.example.newsapp.ui.topheadline.TopHeadlineActivity
import com.example.newsapp.ui.topheadline.TopHeadlineAdapter
import com.example.newsapp.ui.topheadline.TopHeadlineViewModel
import dagger.Module
import dagger.Provides
import me.amitshekhar.newsapp.ui.base.ViewModelProviderFactory

@Module
class ActivityModule(
    private val activity: TopHeadlineActivity
) {

    @ActivityContext
    @Provides
    fun provideContext(): Context {
        return activity
    }

    @Provides
    fun provideNewsListViewModel(topHeadlineRepository: TopHeadlineRepository): TopHeadlineViewModel {
        return ViewModelProvider(activity,
            ViewModelProviderFactory(TopHeadlineViewModel::class) {
                TopHeadlineViewModel(topHeadlineRepository)
            })[TopHeadlineViewModel::class.java]
    }

    @Provides
    fun provideTopHeadlineAdapter(): TopHeadlineAdapter {
        return TopHeadlineAdapter(ArrayList())
    }

//    fun provideTopHeadlineRepository(): TopHeadlineRepository {
//        return TopHeadlineRepository(networkService)
//    }
}