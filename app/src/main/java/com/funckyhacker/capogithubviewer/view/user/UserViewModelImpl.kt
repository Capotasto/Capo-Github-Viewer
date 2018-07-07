package com.funckyhacker.capogithubviewer.view.user

import com.funckyhacker.capogithubviewer.BR
import com.funckyhacker.capogithubviewer.network.GithubRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class UserViewModelImpl @Inject constructor(private val repository: GithubRepository) : UserViewModel() {

    private lateinit var view: UserView

    override var avatarUrl: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.avatarUrl)
        }

    override var login: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.login)
        }

    override var name: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.name)
        }

    override var location: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.location)
        }

    override var email: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.email)
        }

    override var followers: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.followers)
        }

    override var following: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.following)
        }

    override var gists: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.gists)
        }

    override var repos: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.repos)
        }

    override var company: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.company)
        }

    override var blog: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.blog)
        }

    override fun init(view: UserView, login: String) {
        this.view = view
        getUser(login)
    }

    private fun getUser(login: String) {
        repository.user(login)
                .compose(view.getRxLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {user ->
                            avatarUrl = user.avatarUrl ?: ""
                            this.login = user.login
                            name = user.name ?: ""
                            location = user.location ?: ""
                            email = user.email ?: ""
                            followers = user.followers.toString()
                            following = user.following.toString()
                            gists = user.publicGists.toString()
                            repos = user.publicRepos.toString()
                            company = user.company ?: ""
                            blog = user.blog ?: ""
                        },
                        {e -> Timber.w(e)})
    }
}
