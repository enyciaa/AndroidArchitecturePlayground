package com.example.myapplication.services

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

const val GITHUB_BASE_URL: String = "https://api.github.com/"

interface GitHubApi {
    @GET("/users/{user}/repos")
    fun fetchCodeRepos(@Path("user") user: String): Observable<List<GithubRepoEntity>>
}