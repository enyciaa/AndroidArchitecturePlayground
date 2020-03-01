package com.example.myapplication.ui.main

import com.example.myapplication.di.SingleActivity
import com.example.myapplication.domain.Announcer
import com.example.myapplication.services.GithubRepoEntity
import com.example.myapplication.services.GithubService
import com.example.myapplication.domain.Navigator
import com.example.myapplication.ui.base.BaseViewModel
import com.example.myapplication.ui.base.BaseViewState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@SingleActivity
class MainViewModel @Inject constructor(
        private val githubService: GithubService,
        private val navigator: Navigator,
        private val announcer: Announcer
) : BaseViewModel<MainViewModel.ViewState>() {

    private val TEST_USER: String = "JakeWharton"
    override var lastViewState = ViewState()

    fun loadResults() {
        emit(lastViewState.copy(loadingIsVisible = true))
        githubService.fetchCodeRepos(TEST_USER)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            emit(lastViewState.copy(results = it))
                        },
                        {
                            announcer.announce(it.toString())
                        },
                        {
                            emit(lastViewState.copy(loadingIsVisible = false))
                        }
                ).addToComposite()
    }

    fun repoClicked(githubRepoEntity: GithubRepoEntity) {
        navigator.goToDetails(githubRepoEntity)
    }

    data class ViewState(
            val loadingIsVisible: Boolean = false,
            val results: List<GithubRepoEntity> = listOf()
    ) : BaseViewState
}
