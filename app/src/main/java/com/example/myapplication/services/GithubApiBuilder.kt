package com.example.myapplication.services

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class GithubApiBuilder @Inject constructor() {

    fun buildApi(): GitHubApi {
        val builder = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(GITHUB_BASE_URL)
                .build()
        return builder.create(GitHubApi::class.java)
    }
}