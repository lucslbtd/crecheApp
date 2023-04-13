package com.example.crecheapp.profile

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.crecheapp.home.MapsActivity
import com.example.crecheapp.R
import com.example.crecheapp.chat.ChatActivity
import com.example.crecheapp.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.navigationBar.selectedItemId = R.id.profile

        navigationBar()
    }

    private fun navigationBar() = with(binding) {
        navigationBar.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.profile -> {
                    true
                }
                R.id.chat -> {
                    val intent = Intent(this@ProfileActivity, ChatActivity::class.java)
                    startActivity(intent)
                    finish()
                    true
                }
                R.id.home -> {
                    val intent = Intent(this@ProfileActivity, MapsActivity::class.java)
                    startActivity(intent)
                    finish()
                    true
                }
                else -> {
                    false
                }
            }
        }
    }
}
