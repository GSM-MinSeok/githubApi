package com.minstone.gitapi


import android.content.Context
import android.content.Intent
import android.graphics.Canvas
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.ViewUtils
import com.bumptech.glide.Glide
import com.minstone.gitapi.DTO.Api
import com.minstone.gitapi.DTO.Github_Data
import com.minstone.gitapi.DTO.UserData
import com.minstone.gitapi.DTO.UserData.avatar_url
import com.minstone.gitapi.DTO.UserData.bio
import com.minstone.gitapi.DTO.UserData.followers
import com.minstone.gitapi.DTO.UserData.following
import com.minstone.gitapi.DTO.UserData.html_url
import com.minstone.gitapi.DTO.UserData.id
import com.minstone.gitapi.DTO.UserData.login


import com.minstone.gitapi.DTO.Username
import com.minstone.gitapi.databinding.ActivityMain2Binding
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity2 : AppCompatActivity() {
    val BASE_URL = "https://api.github.com/"
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val data: String? = intent.extras?.getString("username")
        Username.username = data.toString()

       getData()
       Handler(Looper.getMainLooper()).postDelayed({
           dataInput()
       },1000)

        //CustomView().invalidate()
    }
    fun getData() {
        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var api = retrofit.create(Api::class.java)

        var call = api.getUsers(userid = Username.username)

        call.enqueue(object : Callback<Github_Data>{
            override fun onResponse(call: Call<Github_Data>, response: Response<Github_Data>) {
                val userData = response.body()
                UserData.id = userData?.id.toString()
                UserData.avatar_url= userData?.avatar_url.toString()
                UserData.html_url= userData?.html_url.toString()
                UserData.followers = userData?.followers
                UserData.following = userData?.following
                UserData.bio = userData?.bio.toString()
                UserData.login = userData?.login.toString()

            }

            override fun onFailure(call: Call<Github_Data>, t: Throwable) {

            }

        })


    }
    fun dataInput(){
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

    }
    class CustomView(context: Context?, attrs: AttributeSet?) : View(context, attrs){

    }

}