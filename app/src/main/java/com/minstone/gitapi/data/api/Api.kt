package com.minstone.gitapi.data.api

import com.minstone.gitapi.data.dto.GithubData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET("users/{userId}")
    suspend fun getUsers(@Path("userId")userId:String): Response<GithubData>
}