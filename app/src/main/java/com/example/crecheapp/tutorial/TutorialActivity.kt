package com.example.crecheapp.tutorial

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.crecheapp.R
import com.example.crecheapp.databinding.ActivityTutorialFlowBinding

class TutorialActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTutorialFlowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTutorialFlowBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navHostController()
    }

    private fun navHostController() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerViewTutorial) as NavHostFragment
        val navController: NavController = navHostFragment.navController
        NavigationUI.setupActionBarWithNavController(this, navController)
    }
}
