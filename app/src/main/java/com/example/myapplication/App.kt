package com.example.myapplication

import com.example.myapplication.di.DaggerAndroidPlaygroundComponent
import com.example.myapplication.services.GithubService
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Inject

class App : DaggerApplication() {

    @Inject lateinit var githubService: GithubService

    override fun applicationInjector(): AndroidInjector<App> {
        return DaggerAndroidPlaygroundComponent.builder()
                .build()
    }
}
