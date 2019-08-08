package com.example.ying_anthem.viewModel

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.ying_anthem.NewFeedApplication
import com.example.ying_anthem.model.dao.NewFeedDao
import com.example.ying_anthem.model.pojo.Article
import javax.inject.Inject

class NewFeedViewModel: ViewModel() {

    @Inject
    lateinit var newFeedDao: NewFeedDao

    fun getNewFeed(application: Application):MutableLiveData<ArrayList<Article>>{

        (application as NewFeedApplication).getFeedDaoComponent().injectNewFeedDaoModule(this)

        return newFeedDao.getFeedDao(application)
    }


}