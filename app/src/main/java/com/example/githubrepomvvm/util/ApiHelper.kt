package com.example.githubrepomvvm.util

import com.example.githubrepomvvm.model.response.BaseResponse
import com.example.githubrepomvvm.model.response.GithubResponse
import io.reactivex.Single

class ApiHelper(private val api: GithubApi) {

    fun getApiHelper(nickname: String)  =
        api.getSearchRepositories(nickname)

    fun getUserApiHelper(nickname: String)  =
        api.getUserRepositories(nickname)

}