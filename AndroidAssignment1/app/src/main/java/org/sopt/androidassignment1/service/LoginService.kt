package org.sopt.androidassignment1.service

import org.sopt.androidassignment1.model.RequestLoginData
import org.sopt.androidassignment1.model.ResponseLoginData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface LoginService {
    @Headers("Content-Type:application/json")
    @POST("user/login")
    fun postLogin(
        @Body body: RequestLoginData
    ) : Call<ResponseLoginData>
}