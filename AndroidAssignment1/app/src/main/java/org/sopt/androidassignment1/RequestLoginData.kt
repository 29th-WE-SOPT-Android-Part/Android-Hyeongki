package org.sopt.androidassignment1

import com.google.gson.annotations.SerializedName

data class RequestLoginData(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: Data
)
{
    data class Data(
        val id: Int,
        val name: String,
        val email: String
    )
}
