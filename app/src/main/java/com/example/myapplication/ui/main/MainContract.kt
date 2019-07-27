package com.example.myapplication.ui.main

import com.example.myapplication.ui.base.BasePresenter
import com.example.myapplication.ui.base.BaseView
import com.example.myapplication.services.GithubRepoEntity

interface MainContract {
    interface View : BaseView {
        fun showResults(results: List<GithubRepoEntity>)
        fun showProgress()
        fun hideProgress()
    }

    interface Presenter : BasePresenter<View> {
        fun loadResults()
    }
}