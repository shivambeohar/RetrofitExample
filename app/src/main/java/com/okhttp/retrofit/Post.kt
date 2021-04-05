package com.okhttp.retrofit

import com.google.gson.annotations.SerializedName

data class Post(
    @SerializedName("userId")
    val mUserId: Long,
    @SerializedName("id")
    val mId: Int,
    @SerializedName("title")
    val mTitle: String,
    @SerializedName("body")
    val mBody: String
)