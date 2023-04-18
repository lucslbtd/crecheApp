package com.example.crecheapp.loginFlow.data

import com.example.crecheapp.loginFlow.model.LoginResponse
import com.example.crecheapp.loginFlow.network.ServiceConnector
import com.google.android.gms.common.api.ApiException
import retrofit2.Response
import java.io.IOException

class LoginRepository(private val apiService: ServiceConnector) {

    /*suspend fun login(email: String, password: String): LoginResponse? {
        try {
            val response = apiService.login(email, password)
            if (response.code() in 200..299) {
                return response.body()
            } else {
                val errorResponse = response.errorBody()?.string()
            }
        } catch (e: IOException) {
            //throw ApiException("Erro de rede")
        } catch (e: Exception) {
            //throw ApiException("Erro desconhecido")
        }
        return null
    }*/
}