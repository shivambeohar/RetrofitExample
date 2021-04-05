package com.okhttp.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.tv_jsondata)

        var retrofit: Retrofit = Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        var jsonPlaceholderApi: JsonPlaceholderApi = retrofit.create(JsonPlaceholderApi::class.java)
        var call: Call<List<Post>> = jsonPlaceholderApi.getAllPost()
        call.enqueue(object : Callback<List<Post>>{
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                Log.i("MainActivity","response code - ${response.code()}\n${response.headers()})")
                var body = ""
                val list:List<Post>? = response.body()
                Log.i("MainActivity","$list")
                if (list != null) {
                    for(post in list)
                        body = "${body}userId: ${post.mUserId}\nid: ${post.mId}\ntitle: ${post.mTitle}\nbody: ${post.mBody}\n\n"
                }
                textView.text = body
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {

            }

        })
    }
}