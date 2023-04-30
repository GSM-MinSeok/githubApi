package com.minstone.gitapi.presentation


import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

import com.minstone.gitapi.databinding.ActivityMain2Binding
import com.minstone.gitapi.presentation.vm.ResultViewModel

class MainActivity2 : AppCompatActivity() {
    private val viewModel by viewModels<ResultViewModel>()

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra("username").toString()
        Log.d("testt_intent", username)

        viewModel.searchUser(username)

        viewModel.userInfo.observe(this){
            Log.d("testt_activity",it.toString())
            binding.textUserId.text = it.userId
            binding.textUsername.text = it.username
            binding.textBio.text = it.bio
            binding.textFollowing.text = it.following.toString()
            binding.textFollowers.text = it.followers.toString()
            Glide.with(this)
                .load(it.userProfile)
                .into(binding.imgProfile)
        }
    }
}