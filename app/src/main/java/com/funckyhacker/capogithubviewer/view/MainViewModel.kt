package com.funckyhacker.capogithubviewer.view

import android.databinding.BaseObservable

abstract class MainViewModel : BaseObservable() {

    abstract fun init(view: MainView)

    abstract fun getAllList()
}
