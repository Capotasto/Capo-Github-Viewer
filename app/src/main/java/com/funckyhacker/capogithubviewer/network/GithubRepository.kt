package com.funckyhacker.capogithubviewer.network

import com.funckyhacker.capogithubviewer.model.User
import io.reactivex.Single
import retrofit2.Retrofit

class GithubRepository(retrofit: Retrofit) {

    private val api: GithubApi = retrofit.create(GithubApi::class.java)

    fun users(sinceId: String): Single<List<User>> {
        return api.users(sinceId)
    }

    fun user(username: String): Single<User> {
        return api.user(username)
    }
}
