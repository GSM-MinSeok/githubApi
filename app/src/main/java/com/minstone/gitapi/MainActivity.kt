package com.minstone.gitapi

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.minstone.gitapi.DTO.Username
import com.minstone.gitapi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btnOpen.setOnClickListener {
           var username:String =  binding.etUsername.text.toString().trim()
            val intent = Intent(this,MainActivity2::class.java)
            intent.putExtra("username",username)
            startActivity(intent)
        }




    }

}