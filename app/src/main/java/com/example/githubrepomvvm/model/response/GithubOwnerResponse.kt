package com.example.githubrepomvvm.model.response



data class GithubOwnerResponse(
    val id : Int,
    val name : String,
    val fullName : String,
    val owner : List<GithubSubResponse>
)

data class GithubSubResponse(
    val login : String,
    val reposUrl : String,
)


