package com.example.crecheapp.loginFlow.ui.login.responsavelLogin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.crecheapp.R
import com.example.crecheapp.databinding.ParentSingUpFlowBinding

class ResponsavelFlowActivity : AppCompatActivity() {

    private lateinit var binding: ParentSingUpFlowBinding
    val basicInfoFragment = BasicInfoFragment()
    val adressInfoFragment = AdressInfoFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ParentSingUpFlowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().apply {
            add(R.id.fragment_container, basicInfoFragment, "Basic Info")
            commit()
        }
    }
}
