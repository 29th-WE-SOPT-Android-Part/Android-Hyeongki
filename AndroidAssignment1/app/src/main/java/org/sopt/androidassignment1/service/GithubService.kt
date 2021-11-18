package org.sopt.androidassignment1.service

import org.sopt.androidassignment1.model.RequestLoginData
import org.sopt.androidassignment1.model.ResponseFollowerData
import org.sopt.androidassignment1.model.ResponseGIthubUserData
import org.sopt.androidassignment1.model.ResponseLoginData
import retrofit2.Call
import retrofit2.http.*

interface GithubService {
    @Headers("Content-Type:application/json")
    @GET("users/{login}/followers")
    fun getFollowers(
        @Path("login") login: String
    ) : Call<List<ResponseFollowerData>>

    @Headers("Content-Type:application/json")
    @GET("users/{login}")
    fun getUser(
        @Path("login") login: String
    ) : Call<ResponseGIthubUserData>
}