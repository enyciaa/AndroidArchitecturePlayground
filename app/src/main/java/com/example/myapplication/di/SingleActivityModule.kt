package com.example.myapplication.di

import com.example.myapplication.domain.Announcer
import com.example.myapplication.ui.AndroidPlaygroundActivity
import com.example.myapplication.domain.Navigator
import com.example.myapplication.ui.AnnouncerImpl
import com.example.myapplication.ui.NavigatorImpl
import com.example.myapplication.ui.details.DetailsFragment
import com.example.myapplication.ui.main.MainFragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface SingleActivityModule {

    @SingleActivity
    @ContributesAndroidInjector(
            modules = [
                FragmentModule::class,
                ActivityScopedModule::class
            ]
    )
    fun androidPlaygroundActivity(): AndroidPlaygroundActivity
}

@Module
interface FragmentModule {

    @ContributesAndroidInjector
    fun mainFragment(): MainFragment

    @ContributesAndroidInjector
    fun detailsFragment(): DetailsFragment
}

@Module
interface ActivityScopedModule {

    @Binds
    fun navigator(navigatorImpl: NavigatorImpl): Navigator

    @Binds
    fun announcer(announcerImpl: AnnouncerImpl): Announcer
}
