package com.example.githubrepomvvm.repository

import com.example.githubrepomvvm.model.response.GithubResponse
import com.example.githubrepomvvm.util.GithubApi
import io.reactivex.Single
import javax.inject.Inject


class GithubRepository @Inject constructor(private val githubApi: GithubApi) {

    fun getApiHelperWithRx(nickname: String): Single<List<GithubResponse>> {
        return githubApi.getSearchRepositories(nickname).flatMap {
            Single.just(it.items)
        }
    }
}