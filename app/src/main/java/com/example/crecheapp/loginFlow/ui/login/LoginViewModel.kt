package com.example.crecheapp.loginFlow.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.crecheapp.loginFlow.data.LoginRepository
import com.example.crecheapp.loginFlow.model.LoginResponse
import com.example.crecheapp.loginFlow.network.ServiceConnector
import com.google.android.gms.common.api.Api
import com.google.android.gms.common.api.ApiException
import kotlinx.coroutines.launch
import java.io.IOException

class LoginViewModel : ViewModel() {
    private val api = ServiceConnector()

    private val _response = MutableLiveData<LoginResponse>()
    val response: LiveData<LoginResponse> = _response

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _response.value = api.login(email, password)
        }
    }
}
