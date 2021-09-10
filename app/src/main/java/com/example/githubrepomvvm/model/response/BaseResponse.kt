package com.example.githubrepomvvm.model.response

data class BaseResponse<T>(
    val totalCount : Int,
    val incompleteResults: Boolean,
    val items : List<T>
)