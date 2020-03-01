package com.example.myapplication.domain

import com.example.myapplication.services.GithubRepoEntity

interface Navigator {
    fun goToDetails(githubRepoEntity: GithubRepoEntity)
    fun goToUrl(url: String)
}