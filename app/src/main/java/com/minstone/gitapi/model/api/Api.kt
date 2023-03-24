package com.minstone.gitapi.model.api

import com.minstone.gitapi.model.data.GithubData
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET("users/{userId}")
    fun getUsers(@Path("userId")userId:String): retrofit2.Call<GithubData>
}