package com.example.mvvm.models

data class ResponseRegister(
    val email: String,
    val id: Int,
    val login: String,
    val token: String
)