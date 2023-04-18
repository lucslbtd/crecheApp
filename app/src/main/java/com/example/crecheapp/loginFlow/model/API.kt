package com.example.crecheapp.loginFlow.model

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

class API {
    interface SignUpApi {
        @POST("/register")
        suspend fun register(
            @Body request: SignUpRequest
        ): SignUpResponse
    }

    interface LoginApi {
        @POST("/auth/login")
        suspend fun login(
            @Body request: LoginRequest
        ): LoginResponse
    }
}
