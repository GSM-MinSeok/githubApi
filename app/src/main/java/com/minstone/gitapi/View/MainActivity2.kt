package com.minstone.gitapi.View


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

import com.minstone.gitapi.model.data.GithubData

import com.minstone.gitapi.databinding.ActivityMain2Binding
import com.minstone.gitapi.model.api.RetorfitBuilder
import com.minstone.gitapi.model.api.RetorfitBuilder.api
import retrofit2.*

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val data: String? = intent.extras?.getString("username")
        val username: String = data.toString()

        userDataLoad(username)

    }

    fun userDataLoad(username: String) {
        val call = api.getUsers(userId = username)

        call.enqueue(object : Callback<GithubData> {
            override fun onResponse(call: Call<GithubData>, response: Response<GithubData>) {
                val userInfo = response.body()
                Log.d("testt",userInfo.toString())
                binding.textFollowers.text = userInfo?.followers.toString()
                binding.textFollowing.text = userInfo?.following.toString()
                binding.textUsername.text = userInfo?.userName.toString()
                binding.textUserid.text = userInfo?.userId.toString()
                binding.textOneline.text = userInfo?.bio.toString()
                Glide.with(this@MainActivity2)
                    .load(userInfo?.userProfile)
                    .into(binding.imgProfile)
            }

            override fun onFailure(call: Call<GithubData>, t: Throwable) {
                Log.d("testt","Fail")
            }
        })
    }
}