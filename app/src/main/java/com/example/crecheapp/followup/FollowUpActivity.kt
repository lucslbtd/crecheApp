package com.example.crecheapp.followup

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.crecheapp.R
import com.example.crecheapp.chat.ChatActivity
import com.example.crecheapp.databinding.ActivityChildInfosBinding
import com.example.crecheapp.home.MapsActivity
import com.example.crecheapp.profile.ProfileActivity

class FollowUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChildInfosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChildInfosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.navigationBar.selectedItemId = R.id.child

        navigationBar()
    }

    private fun navigationBar() = with(binding) {
        navigationBar.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.child -> {
                    true
                }
                R.id.chat -> {
                    val intent = Intent(this@FollowUpActivity, ChatActivity::class.java)
                    startActivity(intent)
                    finish()
                    true
                }
                R.id.home -> {
                    val intent = Intent(this@FollowUpActivity, MapsActivity::class.java)
                    startActivity(intent)
                    finish()
                    true
                }
                R.id.profile -> {
                    val intent = Intent(this@FollowUpActivity, ProfileActivity::class.java)
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
