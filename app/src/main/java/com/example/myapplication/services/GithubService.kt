package com.example.myapplication.services

import io.reactivex.Observable
import javax.inject.Inject

class GithubService @Inject constructor(
        private val githubApiBuilder: GithubApiBuilder
) {

    private val githubApi: GitHubApi = githubApiBuilder.buildApi()

    fun fetchCodeRepos(username: String): Observable<List<GithubRepoEntity>> {
        return githubApi.fetchCodeRepos(username)
    }
}