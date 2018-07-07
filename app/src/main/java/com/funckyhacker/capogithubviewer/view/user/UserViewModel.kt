package com.funckyhacker.capogithubviewer.view.user

import android.databinding.BaseObservable
import android.databinding.Bindable

abstract class UserViewModel : BaseObservable() {

    abstract fun init(view: UserView, login: String)

    @get: Bindable
    abstract var avatarUrl: String

    @get: Bindable
    abstract var login: String

    @get: Bindable
    abstract var name: String

    @get: Bindable
    abstract var location: String

    @get: Bindable
    abstract var email: String

    @get: Bindable
    abstract var followers: String

    @get: Bindable
    abstract var following: String

    @get: Bindable
    abstract var gists: String

    @get: Bindable
    abstract var repos: String

    @get: Bindable
    abstract var company: String

    @get: Bindable
    abstract var blog: String
}
