package com.minstone.gitapi.DTO

import retrofit2.http.GET
import retrofit2.http.Path

public interface Api {
    @GET("users/{userid}")
    fun getUsers(@Path("userid")userid:String): retrofit2.Call<Github_Data>
}