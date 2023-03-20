package com.minstone.gitapi.DTO

import android.media.Image
import java.net.URL

data class Github_Data (
    var login : String?,
    var id : String?,
    var avatar_url:String?,
    var html_url:String?,
    var bio:String?,
    var followers:Int?,
    var following:Int?
)
