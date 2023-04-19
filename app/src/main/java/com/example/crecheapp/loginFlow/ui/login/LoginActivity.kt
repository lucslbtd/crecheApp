package com.example.crecheapp.loginFlow.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.crecheapp.databinding.LoginScreenBinding
import com.example.crecheapp.home.MapsActivity
import com.example.crecheapp.loginFlow.data.LoginRepository
import com.example.crecheapp.tutorial.TutorialActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: LoginScreenBinding
    private lateinit var context: Context
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        context = this

        backTSingUp()
        openMaps()
    }

    private fun verifyFields(): Boolean = with(binding) {
        val txtEmail = email.text
        val txtPassword = password.text
        when {
            txtEmail.isEmpty() && txtPassword.isEmpty() -> {
                Toast.makeText(context, "Os campos não foram preenchidos", Toast.LENGTH_SHORT)
                    .show()
                false
            }
            txtEmail.isEmpty() -> {
                Toast.makeText(context, "Preencha seu email", Toast.LENGTH_SHORT).show()
                false
            }
            txtPassword.isEmpty() -> {
                Toast.makeText(context, "Preencha sua senha", Toast.LENGTH_SHORT).show()
                false
            }
            else -> {
                true
            }
        }
    }

    private fun openMaps() = with(binding) {
        btnLogin.setOnClickListener {
            if (verifyFields()) {
                onClickLoginButton()
                val intent = Intent(context, TutorialActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun backTSingUp() = with(binding) {
        txtBackSingUp.setOnClickListener {
            val intent = Intent(context, SingUpActivity::class.java)
            startActivity(intent)
        }
    }

    fun onClickLoginButton() = with(binding) {
        val email = email.text.toString()
        val password = password.text.toString()
        viewModel.login(email, password)
    }
}
