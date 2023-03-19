package com.minstone.gitapi


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.minstone.gitapi.DTO.Api
import com.minstone.gitapi.DTO.Github_Data
import com.minstone.gitapi.DTO.UserData
import com.minstone.gitapi.DTO.UserData.follower
import com.minstone.gitapi.DTO.UserData.following
import com.minstone.gitapi.DTO.UserData.oneline
import com.minstone.gitapi.DTO.UserData.url
import com.minstone.gitapi.DTO.UserData.userId
import com.minstone.gitapi.DTO.UserData.userProfile
import com.minstone.gitapi.DTO.UserData.username
import com.minstone.gitapi.DTO.Username
import com.minstone.gitapi.databinding.ActivityMain2Binding
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity2 : AppCompatActivity() {
    val BASE_URL = "https://api.github.com/users/"
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding = ActivityMain2Binding.inflate(layoutInflater)


        val data: String? = intent.extras?.getString("username")
        Username.username = data.toString()
        Log.d("dataa",data!!)
        getData()


    }
    fun getData() {
        var retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var api = retrofit.create(Api::class.java)

        var call = api.getUsers(userid = Username.username)

        call.enqueue(object : retrofit2.Callback<Github_Data>{
            override fun onResponse(call: Call<Github_Data>, response: Response<Github_Data>) {
                val userData = response.body()
                UserData.userId = userData!!.userId.toString()
                UserData.userProfile= userData!!.userProfile.toString()
                UserData.url= userData!!.url.toString()
                UserData.follower = userData.follower!!.toInt()
                UserData.following = userData.following!!.toInt()
                UserData.oneline = userData!!.oneline.toString()
                UserData.username = userData!!.username.toString()

            }

            override fun onFailure(call: Call<Github_Data>, t: Throwable) {

            }

        })


    }
    fun dataInput(){
        binding.textUsername.text = username
        binding.textUserid.text = userId
        binding.textFollowers.text = follower.toString()
        binding.textFollowing.text = following.toString()
        binding.textOneline.text = oneline
        Username.URl = url.toString()
        Glide.with(this@MainActivity2)
            .load("${userProfile.toString()}")
            .into(binding.imgProfile)

    }

}