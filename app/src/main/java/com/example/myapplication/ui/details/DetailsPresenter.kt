package com.example.myapplication.ui.details

import com.example.myapplication.services.GithubRepoEntity
import javax.inject.Inject

class DetailsPresenter @Inject constructor() : DetailsContract.Presenter {

    private var view: DetailsContract.View? = null
    private lateinit var githubRepoEntity: GithubRepoEntity

    override fun attachView(view: DetailsContract.View) {
        this.view = view
    }

    override fun initData(githubRepoEntity: GithubRepoEntity) {
        this.githubRepoEntity = githubRepoEntity
        view?.setToolbarTitle(githubRepoEntity.name)
        view?.setUrlAddress(githubRepoEntity.url)
    }

    override fun detachView() {
        this.view = null
    }

    override fun onGoToRepositoryClicked() {
        view?.startUrl(githubRepoEntity.url)
    }
}