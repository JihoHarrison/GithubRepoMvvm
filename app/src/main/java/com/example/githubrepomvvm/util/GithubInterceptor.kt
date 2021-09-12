package com.example.githubrepomvvm.util

import com.example.githubrepomvvm.BuildConfig
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.Interceptor
import okhttp3.Response
//class GithubInterceptor : Interceptor {
//    override fun intercept(chain: Interceptor.Chain): Response {
//        val response = chain.request()
//            .newBuilder()
//            .addHeader("Authorization", BuildConfig.GITHUB_PERSONAL_ACCESS_TOKEN)
//            .build()
//
//        return chain.proceed(response)
//
//    }
//}