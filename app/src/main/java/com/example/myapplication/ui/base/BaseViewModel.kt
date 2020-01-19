package com.example.myapplication.ui.base

import androidx.annotation.CallSuper
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.BehaviorSubject

abstract class BaseViewModel<T : BaseViewState> : LifecycleReceiver {

    abstract var lastViewState: T
    val viewStateEmitter = BehaviorSubject.create<T>()
    private var compositeDisposable: CompositeDisposable = CompositeDisposable()

    @CallSuper
    override fun onAttach() {
        if (compositeDisposable.isDisposed) {
            compositeDisposable = CompositeDisposable()
        }
    }

    @CallSuper
    override fun onDetach() {
        compositeDisposable.dispose()
    }

    protected fun emit(viewState: T) {
        viewStateEmitter.onNext(viewState)
        lastViewState = viewState
    }

    protected fun Disposable.addToComposite() {
        compositeDisposable.add(this)
    }
}