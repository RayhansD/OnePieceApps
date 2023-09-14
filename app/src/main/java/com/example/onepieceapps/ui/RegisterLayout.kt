package com.example.onepieceapps.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.onepieceapps.MainActivity
import com.example.onepieceapps.R
import com.example.onepieceapps.databinding.ActivityRegisterLayoutBinding

class RegisterLayout : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            val data = binding.etName.text.toString()
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("name", data)
            startActivity(intent)
        }
    }
}