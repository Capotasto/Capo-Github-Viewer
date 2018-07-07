package com.funckyhacker.capogithubviewer.util

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.funckyhacker.capogithubviewer.R
import com.funckyhacker.capogithubviewer.di.GlideApp

object BindingAdapters {

    @JvmStatic
    @BindingAdapter("imageUrl")
    fun setImageUrl(imageView: ImageView, imageUrl: String) {
        GlideApp.with(imageView.context).load(imageUrl).fallback(R.drawable.ic_github).into(imageView)
    }
}
