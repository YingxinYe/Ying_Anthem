package com.example.ying_anthem.di.module

import android.app.Application
import com.example.ying_anthem.viewModel.network.NewFeedService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NewFeedBaseServiceModule {

    var builder: Retrofit.Builder? = null

    init {
        builder = Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())

    }

    constructor(application: Application) {}

    @Provides
    @Singleton
    fun createService():NewFeedService{
        val retrofit = builder?.build()
        return retrofit!!.create(NewFeedService::class.java)
    }
}