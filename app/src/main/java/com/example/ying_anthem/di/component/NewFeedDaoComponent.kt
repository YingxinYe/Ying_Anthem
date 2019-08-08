package com.example.ying_anthem.di.component

import com.example.ying_anthem.di.module.NewFeedDaoModule
import com.example.ying_anthem.viewModel.NewFeedViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NewFeedDaoModule::class])
interface NewFeedDaoComponent{

    fun injectNewFeedDaoModule(newFeedViewModel: NewFeedViewModel)
}