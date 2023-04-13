package com.example.crecheapp.chat

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.crecheapp.home.MapsActivity
import com.example.crecheapp.R
import com.example.crecheapp.databinding.ActivityChatBinding
import com.example.crecheapp.profile.ProfileActivity

class ChatActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChatBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navigationBar()
        binding.navigationBar.selectedItemId = R.id.chat
    }

    private fun navigationBar() = with(binding) {
        navigationBar.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.chat -> {
                    true
                }
                R.id.profile -> {
                    val intent = Intent(this@ChatActivity, ProfileActivity::class.java)
                    startActivity(intent)
                    finish()
                    true
                }
                R.id.home -> {
                    val intent = Intent(this@ChatActivity, MapsActivity::class.java)
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
