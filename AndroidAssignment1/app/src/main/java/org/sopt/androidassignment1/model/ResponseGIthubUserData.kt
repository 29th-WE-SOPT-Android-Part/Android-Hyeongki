package org.sopt.androidassignment1.model

import com.google.gson.annotations.SerializedName

data class ResponseGIthubUserData(
    @SerializedName("login")
    val login: String,
    @SerializedName("avatar_url")
    val avatar_url: String,
    @SerializedName("html_url")
    val html_url: String,
    @SerializedName("bio")
    val bio: String,
    @SerializedName("public_repos")
    val public_repos: Int,
    @SerializedName("followers")
    val followers: Int,
    @SerializedName("following")
    val following: Int
)
