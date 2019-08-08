package com.example.ying_anthem

import android.app.Application
import com.example.ying_anthem.di.component.DaggerNewFeedBaseServiceComponent
import com.example.ying_anthem.di.component.DaggerNewFeedDaoComponent
import com.example.ying_anthem.di.component.NewFeedBaseServiceComponent
import com.example.ying_anthem.di.component.NewFeedDaoComponent
import com.example.ying_anthem.di.module.NewFeedBaseServiceModule
import com.example.ying_anthem.di.module.NewFeedDaoModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class NewFeedApplication: Application() {

    lateinit var newFeedBaseServiceComponent: NewFeedBaseServiceComponent
    lateinit var newFeedDaoComponent: NewFeedDaoComponent


    override fun onCreate() {
        super.onCreate()
        newFeedBaseServiceComponent = DaggerNewFeedBaseServiceComponent.builder()
            .newFeedBaseServiceModule(NewFeedBaseServiceModule(this))
            .build()

        newFeedDaoComponent = DaggerNewFeedDaoComponent.builder()
            .newFeedDaoModule(NewFeedDaoModule())
            .build()

    }

    fun getFeedBaseServiceComponent():NewFeedBaseServiceComponent{
        return newFeedBaseServiceComponent
    }

    fun getFeedDaoComponent():NewFeedDaoComponent{
        return newFeedDaoComponent
    }
}