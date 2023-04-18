package com.example.crecheapp.loginFlow.ui.login.responsavelLogin

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.crecheapp.R
import com.example.crecheapp.databinding.ParentSingUpFlowBinding
import com.example.crecheapp.loginFlow.ui.login.LoginViewModel

class ResponsavelFlowActivity : AppCompatActivity() {

    private lateinit var binding: ParentSingUpFlowBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ParentSingUpFlowBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navigationController()

        /*viewModel.response.observe(this, { response ->
            Toast.makeText(this, response.message, Toast.LENGTH_SHORT).show()
        })*/
    }

    private fun navigationController() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController: NavController = navHostFragment.navController
        NavigationUI.setupActionBarWithNavController(this, navController)
    }



    /*fun onClickRegisterButton() {
        val request = SignUpRequest(
            User(
                email = "penispenis@hotmail.com",
                password = "penispenispenispenis",
                account_type = "penispenis",
                name = "Spenispenis",
                gender = "penispenis",
                birthday_date = "2001-07-05",
                phone_number = "81997974949",
                document = "24593285593"
            ),
            Child(
                name = "penispenis",
                gender = "penispenis",
                birthday_date = "2001-07-05"
            ),
            Address(
                street = "penispenis",
                number = 1292,
                postal_code = "67890-098",
                city = "penispenis",
                complement = "APTO 809"
            )
        )
        viewModel.register(request)
    }*/
}
