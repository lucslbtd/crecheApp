package com.example.crecheapp.loginFlow.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.crecheapp.MapsActivity
import com.example.crecheapp.databinding.LoginScreenBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: LoginScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        openMaps()
    }

    private fun openMaps() = with(binding) {
        btnLogin.setOnClickListener {
            val intent = Intent(this@LoginActivity, MapsActivity::class.java)
            startActivity(intent)
        }
    }
}
