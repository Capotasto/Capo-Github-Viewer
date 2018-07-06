package com.funckyhacker.capogithubviewer.view

import android.content.Intent
import com.trello.rxlifecycle2.LifecycleTransformer



interface MainView {
    fun setAdapter(adapter: MainAdapter)

    fun startActivity(intent: Intent)

    fun <T> getRxLifecycle(): LifecycleTransformer<T>

}
