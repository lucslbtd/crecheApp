package com.example.crecheapp.loginFlow.ui.login.responsavelLogin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.crecheapp.loginFlow.model.SignUpRequest
import com.example.crecheapp.loginFlow.model.SignUpResponse
import com.example.crecheapp.loginFlow.network.ServiceConnector
import kotlinx.coroutines.launch

class SignUpViewModel : ViewModel() {

    private val serviceConnector = ServiceConnector()

    private val _signupResponse = MutableLiveData<SignUpResponse>()
    val signupResponse: LiveData<SignUpResponse> = _signupResponse

    val signUpData = SignUpRequest()

    fun register(request: SignUpRequest) {
        viewModelScope.launch {
            _signupResponse.value = serviceConnector.register(request)
        }
    }
}