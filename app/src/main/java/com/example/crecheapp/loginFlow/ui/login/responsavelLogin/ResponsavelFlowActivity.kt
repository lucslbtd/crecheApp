package com.example.crecheapp.loginFlow.ui.login.responsavelLogin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.crecheapp.R
import com.example.crecheapp.databinding.ParentSingUpFlowBinding

class ResponsavelFlowActivity : AppCompatActivity() {

    private lateinit var binding: ParentSingUpFlowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ParentSingUpFlowBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController: NavController = navHostFragment.navController
        NavigationUI.setupActionBarWithNavController(this, navController)
    }
}
