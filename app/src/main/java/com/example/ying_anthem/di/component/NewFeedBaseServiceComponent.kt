package com.example.ying_anthem.di.component

import com.example.ying_anthem.di.module.NewFeedBaseServiceModule
import com.example.ying_anthem.model.dao.NewFeedDao
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [NewFeedBaseServiceModule::class])
interface NewFeedBaseServiceComponent {

    fun injectNewFeedBaseServiceComponent(newFeedDao: NewFeedDao)
}