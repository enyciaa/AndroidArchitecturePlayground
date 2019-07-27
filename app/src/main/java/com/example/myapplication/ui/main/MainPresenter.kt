package com.example.myapplication.ui.main

import com.example.myapplication.services.GithubService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainPresenter : MainContract.Presenter {

    private val TEST_USER: String = "JakeWharton"
    private var view: MainContract.View? = null
    private lateinit var githubService: GithubService
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun attachView(view: MainContract.View) {
        this.view = view
        githubService = GithubService()
    }

    override fun detachView() {
        compositeDisposable.dispose()
        this.view = null
    }

    override fun loadResults() {
        view?.showProgress()
        val disposable = githubService.fetchCodeRepos(TEST_USER)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            view?.showResults(it)
                        },
                        {
                            view?.showError(it.toString())
                        },
                        {
                            view?.hideProgress()
                        }
                )
        compositeDisposable.add(disposable)
    }
}