package com.example.githubrepomvvm.util

import com.example.githubrepomvvm.BuildConfig
import com.example.githubrepomvvm.model.response.BaseResponse
import com.example.githubrepomvvm.model.response.GithubOwnerResponse
import com.example.githubrepomvvm.model.response.GithubResponse
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ApiHelper{


    private val GITHUB_API_URL = "https://api.github.com"

    @Singleton
    @Provides
    fun getApiHelper(retrofit: Retrofit) : GithubApi =
        retrofit.create(GithubApi::class.java)

//
//    fun getUserApiHelper(nickname: String) : GithubApi  =
//        getGithubRetrofit().create(G)
//    @Singleton
//    @Provides
//    fun buildOkHttpClient(): OkHttpClient {
//        val interceptor = HttpLoggingInterceptor()
//        if (BuildConfig.DEBUG) {
//            interceptor.level = HttpLoggingInterceptor.Level.BODY
//        } else {
//            interceptor.level = HttpLoggingInterceptor.Level.NONE
//        }
//        return OkHttpClient.Builder()
//            .connectTimeout(5, TimeUnit.SECONDS)
////            .addInterceptor(GithubInterceptor())
//            .build()
//    }

    @Singleton
    @Provides
    fun getGithubRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(GITHUB_API_URL).addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                        .create()
                )
            )
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

}