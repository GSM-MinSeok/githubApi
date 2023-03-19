package com.minstone.gitapi.DTO

import android.media.Image
import java.net.URL

data class Github_Data (
    var username : String?,
    var userId : String?,
    var userProfile:String?,
    var oneline:String?,
    var follower:Int?,
    var following:Int?
)
