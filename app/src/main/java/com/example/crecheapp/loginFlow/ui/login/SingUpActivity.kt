package com.example.crecheapp.loginFlow.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.crecheapp.databinding.CadastroScreenBinding

class SingUpActivity : AppCompatActivity() {

    private lateinit var binding: CadastroScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CadastroScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navigationToCreche()
        navigationToParents()
        goToLogin()
    }

    private fun navigationToCreche() = with(binding) {
        btnCadastroCreche.setOnClickListener {
        }
    }

    private fun navigationToParents() = with(binding) {
        btnCadastroResponsavel.setOnClickListener {
        }
    }

    private fun goToLogin() = with(binding) {
        txtLogin.setOnClickListener {
            val intent = Intent(this@SingUpActivity, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
