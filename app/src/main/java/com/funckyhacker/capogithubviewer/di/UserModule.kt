package com.funckyhacker.capofiler.di

import android.app.Activity
import com.funckyhacker.capogithubviewer.view.user.UserActivity
import com.funckyhacker.capogithubviewer.view.user.UserViewModel
import com.funckyhacker.capogithubviewer.view.user.UserViewModelImpl
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class UserModule {
    @Binds
    @IntoMap
    @ActivityKey(UserActivity::class)
    internal abstract fun bindInjectorFactory(
            builder: UserComponent.Builder): AndroidInjector.Factory<out Activity>

    @Binds
    internal abstract fun bindUserViewModel(viewModel: UserViewModelImpl): UserViewModel

}
