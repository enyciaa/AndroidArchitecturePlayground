package com.example.myapplication.di

import com.example.myapplication.ui.base.BaseActivity
import com.example.myapplication.ui.details.DetailsActivity
import com.example.myapplication.ui.main.MainActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityModule {

    @ContributesAndroidInjector
    fun detailsActivity(): DetailsActivity

    @ContributesAndroidInjector
    fun mainActivity(): MainActivity
}