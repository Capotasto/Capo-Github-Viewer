package com.funckyhacker.capofiler.di

import android.app.Activity
import com.funckyhacker.capogithubviewer.view.MainActivity
import com.funckyhacker.capogithubviewer.view.MainViewModel
import com.funckyhacker.capogithubviewer.view.MainViewModelImpl
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class MainModule {
    @Binds
    @IntoMap
    @ActivityKey(MainActivity::class)
    internal abstract fun bindInjectorFactory(
            builder: MainComponent.Builder): AndroidInjector.Factory<out Activity>

    @Binds
    internal abstract fun bindMainViewModel(viewModel: MainViewModelImpl): MainViewModel

}
