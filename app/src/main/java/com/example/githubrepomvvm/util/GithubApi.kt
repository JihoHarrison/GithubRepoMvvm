package com.example.githubrepomvvm.util

import com.example.githubrepomvvm.model.response.BaseResponse
import com.example.githubrepomvvm.model.response.GithubOwnerResponse
import com.example.githubrepomvvm.model.response.GithubResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface GithubApi {

    @GET("users/{username}/repos")
    fun getUserRepositories(@Path("username") username: String): Single<BaseResponse<GithubOwnerResponse>>

    @GET("search/repositories")
    fun getSearchRepositories(@Query("q") query: String): Single<BaseResponse<GithubResponse>>


}