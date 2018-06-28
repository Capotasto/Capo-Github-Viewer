package com.funckyhacker.capogithubviewer.view

import android.content.Intent

interface MainView {
    fun setAdapter(adapter: MainAdapter)

    fun startActivity(intent: Intent)

}
