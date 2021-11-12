package org.sopt.androidassignment1.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceCreator {
    private const val BASE_URL_SOPT = "https://asia-northeast3-we-sopt-29.cloudfunctions.net/api/"
    private const val BASE_URL_GITHUB = "https://api.github.com/"

    private val retrofitSopt : Retrofit = Retrofit
        .Builder()
        .baseUrl(BASE_URL_SOPT)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val retrofitGithub : Retrofit = Retrofit
        .Builder()
        .baseUrl(BASE_URL_GITHUB)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val loginService : LoginService = retrofitSopt.create(LoginService::class.java)
    val githubService: GithubService = retrofitGithub.create(GithubService::class.java)
}