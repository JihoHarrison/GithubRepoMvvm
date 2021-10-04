package com.example.githubrepomvvm.view

import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.addTo

class BaseActivity : AppCompatActivity() {

    private val disposables by lazy { CompositeDisposable() }

    @CallSuper
    override fun onDestroy() {
        disposables.clear()
        super.onDestroy()
    }

    protected fun Disposable.addToDisposables(): Disposable = addTo(disposables)
}