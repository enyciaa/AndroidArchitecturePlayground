package com.example.myapplication.services

import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class GithubService {

    private val githubApi: GitHubApi

    init {
        val builder = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(GITHUB_BASE_URL)
                .build()
        githubApi = builder.create(GitHubApi::class.java)
    }

    fun fetchCodeRepos(username: String): Observable<List<GithubRepoEntity>> {
        return githubApi.fetchCodeRepos(username)
    }
}