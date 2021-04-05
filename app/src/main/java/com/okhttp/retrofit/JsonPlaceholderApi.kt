package com.okhttp.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface JsonPlaceholderApi {

    @GET("posts")
    fun getAllPost(): Call<List<Post>>
}