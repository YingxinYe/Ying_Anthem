package com.example.ying_anthem.di.module

import com.example.ying_anthem.model.dao.NewFeedDao
import dagger.Module
import dagger.Provides

@Module
class NewFeedDaoModule {

    @Provides
    fun provideDao(): NewFeedDao {
        return NewFeedDao()
    }
}