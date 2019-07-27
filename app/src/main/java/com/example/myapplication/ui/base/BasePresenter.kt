package com.example.myapplication.ui.base

interface BasePresenter<in T : BaseView> {
    fun attachView(view: T)
    fun detachView()
}