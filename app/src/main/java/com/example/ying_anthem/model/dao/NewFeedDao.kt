package com.example.ying_anthem.model.dao

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.example.ying_anthem.NewFeedApplication
import com.example.ying_anthem.model.pojo.Article
import com.example.ying_anthem.model.pojo.News
import com.example.ying_anthem.viewModel.network.NewFeedService
import retrofit2.Call
import retrofit2.Callback
import javax.inject.Inject

class NewFeedDao {

    @Inject
    lateinit var newFeedService: NewFeedService

    //Connect to server and fetch data
    fun getFeedDao(application: Application): MutableLiveData<ArrayList<Article>> {

        val mlist: MutableLiveData<ArrayList<Article>> = MutableLiveData()
        val TAG = "News"

        (application as NewFeedApplication).getFeedBaseServiceComponent().injectNewFeedBaseServiceComponent(this)

        var mycall: Call<News> = newFeedService.retrieveNewFeed()

        mycall.enqueue(object : Callback<News> {
            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.i(TAG, "Fetch fail: " + t.message)
            }

            override fun onResponse(call: Call<News>, response: retrofit2.Response<News>) {
                if (response.body() != null) {
                    mlist.value = response.body()!!.articles
                    Log.i(TAG, "Success: " + response.body()!!.articles.size)
                } else {
                    mlist.value = null
                    Log.i(TAG, "Success fetch but empty" + response)
                }
            }
        })

        return mlist
    }
}