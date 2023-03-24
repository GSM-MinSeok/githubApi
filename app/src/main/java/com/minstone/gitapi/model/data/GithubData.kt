package com.minstone.gitapi.model.data

import com.google.gson.annotations.SerializedName

data class GithubData (
    @SerializedName("login") var userName : String?,
    @SerializedName("id")var userId : String?,
    @SerializedName("avatar_url")var userProfile:String?,
    @SerializedName("bio")var bio:String?,
    @SerializedName("followers")var followers:Int?,
    @SerializedName("following")var following:Int?
)
