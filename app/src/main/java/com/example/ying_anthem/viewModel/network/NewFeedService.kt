package com.example.ying_anthem.viewModel.network

import com.example.ying_anthem.model.pojo.News
import retrofit2.Call

import retrofit2.http.GET

interface NewFeedService {

    @GET("top-headlines?country=us&category=business&apiKey=a413be9a2f074a17b7ce67336f8d3b77")
    fun retrieveNewFeed():Call<News>
}

