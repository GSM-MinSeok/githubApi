package com.minstone.gitapi.data.dto

import com.google.gson.annotations.SerializedName

data class GithubData (
    @SerializedName("login") val username : String?,
    @SerializedName("id")val userId : String?,
    @SerializedName("avatar_url")val userProfile:String?,
    @SerializedName("bio")val bio:String?,
    @SerializedName("followers")val followers:Int?,
    @SerializedName("following")val following:Int?
)
