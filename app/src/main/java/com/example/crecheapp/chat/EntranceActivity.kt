package com.example.crecheapp.chat

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.crecheapp.R
import com.example.crecheapp.databinding.ActivityEntranceBinding
import kotlinx.android.synthetic.main.activity_entrance.*

class EntranceActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityEntranceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEntranceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.button -> enterChatroom()
        }
    }

    private fun enterChatroom() = with(binding) {
        val userName = userName.text.toString()
        val roomName = roomname.text.toString()

        if (!roomName.isNullOrBlank() && !userName.isNullOrBlank()) {
            startActivity<ChatRoomActivity>(
                "userName" to userName,
                "roomName" to roomName
            )
        } else {
            Toast.makeText(this, "Nickname and Roomname should be filled!", Toast.LENGTH_SHORT)
        }
    }
}
