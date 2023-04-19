package com.example.crecheapp.loginFlow.network

import com.example.crecheapp.loginFlow.model.*
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ServiceConnector {



    private val retrofit = Retrofit.Builder()
        .baseUrl("https://1876-2804-7f7-de9d-5333-4065-1a0c-179f-5ff3.ngrok-free.app/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val signUpApi = retrofit.create(API.SignUpApi::class.java)

    suspend fun register(request: SignUpRequest): SignUpResponse {
        return signUpApi.register(request)
    }

    private val loginApi = retrofit.create(API.LoginApi::class.java)

    suspend fun login(email: String, password: String): LoginResponse {
        val request = LoginRequest(email, password)
        return loginApi.login(request)
    }
}
