package com.example.myapplication.ui.details

import com.example.myapplication.services.GithubRepoEntity
import com.example.myapplication.ui.base.BasePresenter
import com.example.myapplication.ui.base.BaseView

interface DetailsContract {
    interface View : BaseView {
        fun startUrl(url: String)
        fun setToolbarTitle(title: String)
        fun setUrlAddress(url: String)
    }

    interface Presenter : BasePresenter<View> {
        fun onGoToRepositoryClicked()
        fun initData(githubRepoEntity: GithubRepoEntity)
    }
}