package com.example.crecheapp.loginFlow.model

class StatusValidator {

    interface LoginCallback {
        fun onSuccess(jwt: String)
        fun onError(errorMessage: String)
    }
}