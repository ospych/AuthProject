package com.example.mvvm.retrofit

import com.example.mvvm.models.RequestRegister
import com.example.mvvm.models.ResponseRegister
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface Api {
    @POST("api/user/register")
    suspend fun register(
        @Body body: RequestRegister
    ): Response<ResponseRegister>
}