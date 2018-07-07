package com.funckyhacker.capofiler.di

import com.funckyhacker.capogithubviewer.view.user.UserActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent
interface UserComponent : AndroidInjector<UserActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<UserActivity>()
}
