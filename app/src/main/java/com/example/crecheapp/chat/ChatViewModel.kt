package com.example.crecheapp.chat

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ChatViewModel : ViewModel() {
    val messages = MutableLiveData<List<String>>()
    fun addMessage(message: String) {
        val newMessages = messages.value?.toMutableList() ?: mutableListOf()
        newMessages.add(message)
        messages.value = newMessages
    }
}