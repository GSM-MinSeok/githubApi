package com.minstone.gitapi.model.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetorfitBuilder {
    val BASE_URL = "https://api.github.com/"

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api = retrofit.create(Api::class.java)
}