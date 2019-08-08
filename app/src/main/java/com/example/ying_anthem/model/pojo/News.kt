package com.example.ying_anthem.model.pojo


data class News(
    val status: String,

    val totalResults: Int,

    val articles: ArrayList<Article>
)
