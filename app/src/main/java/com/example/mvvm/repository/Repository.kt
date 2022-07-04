package com.example.mvvm.repository

import android.provider.ContactsContract
import com.example.mvvm.models.RequestRegister
import com.example.mvvm.models.ResponseRegister
import com.example.mvvm.retrofit.RetrofitBuilder
import retrofit2.Response

class Repository {

    private val api = RetrofitBuilder.api

    suspend fun getUser(name: RequestRegister): Response<ResponseRegister>{
        return api.register(name)
    }

}