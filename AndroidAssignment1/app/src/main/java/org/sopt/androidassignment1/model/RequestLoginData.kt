package org.sopt.androidassignment1.model

import com.google.gson.annotations.SerializedName

data class RequestLoginData(
    @SerializedName("email")
    val email : String,
    val password : String
)
