package com.example.myapplication.ui.base

import dagger.android.support.DaggerFragment
import io.reactivex.disposables.CompositeDisposable

abstract class BaseFragment : DaggerFragment() {

    var compositeDisposable: CompositeDisposable = CompositeDisposable()

    abstract fun getLifecycleReceivers(): List<LifecycleReceiver>

    override fun onStart() {
        super.onStart()
        if (compositeDisposable.isDisposed) {
            compositeDisposable = CompositeDisposable()
        }
        getLifecycleReceivers().forEach { it.onAttach() }
    }

    override fun onStop() {
        super.onStop()
        compositeDisposable.dispose()
        getLifecycleReceivers().forEach { it.onDetach() }
    }
}