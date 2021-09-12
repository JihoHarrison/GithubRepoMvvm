package com.example.githubrepomvvm.repository

import com.example.githubrepomvvm.model.response.BaseResponse
import com.example.githubrepomvvm.model.response.GithubOwnerResponse
import com.example.githubrepomvvm.model.response.GithubResponse
import com.example.githubrepomvvm.util.GithubApi
import dagger.Module
import io.reactivex.Single
import javax.inject.Inject



class GithubRepository @Inject constructor (private val githubApi: GithubApi)  {

    fun getApiHelper(nickname : String) : Single<BaseResponse<GithubResponse>>{
        return githubApi.getSearchRepositories(nickname)
    }





}