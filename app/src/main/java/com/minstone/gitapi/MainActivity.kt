package com.minstone.gitapi

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.minstone.gitapi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.btnOpen.setOnClickListener {
           var username =  binding.etUsername.text.toString()
            val intent = Intent(this@MainActivity,MainActivity2::class.java)
            intent.putExtra(username,"username")
            startActivity(intent)
        }




    }

}