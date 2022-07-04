package com.example.mvvm.retrofit

import com.example.mvvm.App
import com.example.mvvm.utils.SharedPreference
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    var authToken = SharedPreference(App.instance.applicationContext).userToken
    private val retrofit by lazy {
        var client = OkHttpClient.Builder().addInterceptor { chain ->
            chain.proceed(chain.request().newBuilder().also {
                if (authToken != null) {
                    it.addHeader("Authorization", "Bearer $authToken").build()
                }
            }.build())
        }.build()

        Retrofit.Builder()
            .baseUrl("https://yssykol.herokuapp.com:443")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    val api by lazy {
        retrofit.create(Api::class.java)
    }
}