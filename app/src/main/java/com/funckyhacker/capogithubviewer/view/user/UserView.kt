package com.funckyhacker.capogithubviewer.view.user

import com.trello.rxlifecycle2.LifecycleTransformer

interface UserView {

    fun <T> getRxLifecycle(): LifecycleTransformer<T>
}
