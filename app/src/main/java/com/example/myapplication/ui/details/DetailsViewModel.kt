package com.example.myapplication.ui.details

import com.example.myapplication.services.GithubRepoEntity
import com.example.myapplication.ui.base.BaseViewModel
import com.example.myapplication.ui.base.BaseViewState
import javax.inject.Inject

class DetailsViewModel @Inject constructor() : BaseViewModel<DetailsViewModel.ViewState>() {

    override var lastViewState: ViewState = ViewState()
    private lateinit var githubRepoEntity: GithubRepoEntity

    fun initData(githubRepoEntity: GithubRepoEntity) {
        this.githubRepoEntity = githubRepoEntity
        emit(lastViewState.copy(
                toolbarTitle = githubRepoEntity.name,
                urlAddress = githubRepoEntity.url
        ))
    }

    fun onGoToRepositoryClicked() {
        emit(lastViewState.copy(urlAddressToGoTo = githubRepoEntity.url))
    }

    data class ViewState(
            val toolbarTitle: String = "",
            val urlAddress: String = "",
            val urlAddressToGoTo: String = ""
    ) : BaseViewState
}