package com.example.myapplication.ui.details

import com.example.myapplication.di.SingleActivity
import com.example.myapplication.services.GithubRepoEntity
import com.example.myapplication.domain.Navigator
import com.example.myapplication.ui.base.BaseViewModel
import com.example.myapplication.ui.base.BaseViewState
import javax.inject.Inject

@SingleActivity
class DetailsViewModel @Inject constructor(
        private val navigator: Navigator
) : BaseViewModel<DetailsViewModel.ViewState>() {

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
        navigator.goToUrl(githubRepoEntity.url)
    }

    data class ViewState(
            val toolbarTitle: String = "",
            val urlAddress: String = ""
    ) : BaseViewState
}