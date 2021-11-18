package org.sopt.androidassignment1.model

import com.google.gson.annotations.SerializedName

data class ResponseFollowerData(
    @SerializedName("login")
    val login: String,
    @SerializedName("avatar_url")
    val avatar_url: String,
    @SerializedName("html_url")
    val html_url: String,
)
