package com.minstone.gitapi.View


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

import com.minstone.gitapi.model.data.GithubData

import com.minstone.gitapi.databinding.ActivityMain2Binding
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

            }

            override fun onFailure(call: Call<GithubData>, t: Throwable) {
                Log.d("testFail","asdasd")
            }
        })
    }
    /*fun dataInput() {
        Log.d("Log", login.toString())
        binding.textUsername.text = login.toString()
        binding.textUserid.text = id.toString()
        binding.textFollowers.text = followers.toString()
        binding.textFollowing.text = following.toString()
        binding.textOneline.text = bio.toString()
        Username.URl = html_url.toString()
        Glide.with(this@MainActivity2)
            .load("${avatar_url.toString()}")
            .into(binding.imgProfile)

    }*/
}