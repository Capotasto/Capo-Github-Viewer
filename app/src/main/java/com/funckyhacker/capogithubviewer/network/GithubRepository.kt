package com.funckyhacker.capogithubviewer.network

import com.funckyhacker.capogithubviewer.model.User
import io.reactivex.Single
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GithubRepository @Inject constructor(retrofit: Retrofit) {

    private val api: GithubApi by lazy {
        retrofit.create(GithubApi::class.java)
    }

    fun users(sinceId: Int): Single<List<User>> {
        return api.users(sinceId)
    }

    fun user(username: String): Single<User> {
        return api.user(username)
    }
}
