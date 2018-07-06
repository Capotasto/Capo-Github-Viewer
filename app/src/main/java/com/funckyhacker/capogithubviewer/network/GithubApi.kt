package com.funckyhacker.capogithubviewer.network

import com.funckyhacker.capogithubviewer.model.User
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubApi {

    @GET("/users")
    fun users(@Query("since") sinceId: Int): Single<List<User>>

    @GET("/users/{username}")
    fun user(@Path("username") username: String): Single<User>
}
