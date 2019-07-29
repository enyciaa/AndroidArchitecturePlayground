package com.example.myapplication.di

import android.app.Application
import com.example.myapplication.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(
        modules = [
            AndroidInjectionModule::class,
            AndroidSupportInjectionModule::class,
            ActivityModule::class
        ]
)
interface AndroidPlaygroundComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        fun build(): AndroidPlaygroundComponent
    }
}