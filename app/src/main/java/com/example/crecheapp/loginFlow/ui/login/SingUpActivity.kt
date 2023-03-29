package com.example.crecheapp.loginFlow.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.crecheapp.databinding.CadastroScreenBinding
import com.example.crecheapp.loginFlow.ui.login.responsavelLogin.ResponsavelFlowActivity

class SingUpActivity : AppCompatActivity() {

    private lateinit var binding: CadastroScreenBinding
    private lateinit var context: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CadastroScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        observerFunctions()
        context = this
    }

    private fun observerFunctions() {
        navigationToParents()
        goToLogin()
        crecheFlow()
    }

    private fun navigationToCreche() = with(binding) {
        btnCadastroCreche.setOnClickListener {
        }
    }

    private fun navigationToParents() = with(binding) {
        btnCadastroResponsavel.setOnClickListener {
            val intent = Intent(context, ResponsavelFlowActivity::class.java)
            startActivity(intent)
        }
    }

    private fun goToLogin() = with(binding) {
        txtLogin.setOnClickListener {
            val intent = Intent(context, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun crecheFlow() = with(binding) {
        btnCadastroCreche.setOnClickListener {
            Toast.makeText(context, "Feature Indisponivel", Toast.LENGTH_SHORT).show()
        }
    }
}
