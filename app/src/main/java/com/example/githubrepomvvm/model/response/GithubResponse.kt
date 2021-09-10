package com.example.githubrepomvvm.model.response


data class GithubResponse(
    val id : Int,
    val name : String,
    val fullName : String,
    val owner : GithubOwnerResponse,
    val updatedAt : String,
    val stargazersCount : String
)

