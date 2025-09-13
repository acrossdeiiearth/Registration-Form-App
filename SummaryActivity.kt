package com.acrossdeiiglobe.registrationfromapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.acrossdeiiglobe.registrationfromapp.databinding.ActivitySummaryBinding

class SummaryActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySummaryBinding
    private lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySummaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        retrieveUser()
        displayUser()
        setupClickListener()
    }

    private fun retrieveUser() {
        user = intent.getSerializableExtra("User") as User
    }

    private fun displayUser() {
        binding.textViewUserFullName.text = user.getFullName()
        binding.textViewEmailAddress.text = user.email
        binding.textViewPhone.text = user.phone
    }

    private fun setupClickListener() {
        binding.textViewEmailAddress.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:${user.email}")
            }
            startActivity(intent)
        }

        binding.textViewPhone.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:${user.phone}")
            }
            startActivity(intent)
        }
    }
}
