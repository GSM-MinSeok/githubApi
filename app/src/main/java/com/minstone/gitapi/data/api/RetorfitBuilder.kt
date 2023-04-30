package com.minstone.gitapi.data.api

import com.minstone.gitapi.data.dto.GithubData
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
object RetorfitBuilder {
    val BASE_URL = "https://api.github.com/"

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api = retrofit.create(Api::class.java)
    suspend fun getUsers(username: String): Response<GithubData>{
        return api.getUsers(username)
    }
}