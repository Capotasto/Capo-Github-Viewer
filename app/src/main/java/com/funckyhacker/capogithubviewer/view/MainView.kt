package com.funckyhacker.capogithubviewer.view

import com.trello.rxlifecycle2.LifecycleTransformer

interface MainView {
    fun setAdapter(adapter: MainAdapter)

    fun <T> getRxLifecycle(): LifecycleTransformer<T>

}
