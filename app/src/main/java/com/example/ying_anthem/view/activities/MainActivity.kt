package com.example.ying_anthem.view.activities

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.ying_anthem.R
import com.example.ying_anthem.view.fragment.ArticleListFragment
import com.example.ying_anthem.viewModel.NewFeedViewModel

class MainActivity : AppCompatActivity() {

    lateinit var newsFeedViewModel: NewFeedViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        newsFeedViewModel = ViewModelProviders.of(this).get(NewFeedViewModel::class.java)

        supportFragmentManager.beginTransaction().add(R.id.fragment_container, ArticleListFragment()).commit()
    }

    fun getViewModel(): NewFeedViewModel {
        return newsFeedViewModel
    }
}
