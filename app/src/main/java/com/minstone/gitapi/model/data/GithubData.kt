package com.minstone.gitapi.model.data

import com.google.gson.annotations.SerializedName

data class GithubData (
    @SerializedName("login") var name : String?,
    @SerializedName("id")var userId : String?,
    @SerializedName("avartar_url")var userProfile:String?,
    @SerializedName("html_url")var htmlUrl:String?,
    @SerializedName("bio")var bio:String?,
    @SerializedName("follwers")var followers:Int?,
    @SerializedName("following")var following:Int?

)
