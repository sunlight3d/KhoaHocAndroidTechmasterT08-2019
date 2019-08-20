package com.example.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class MainActivity : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        //val url = "https://jsonplaceholder.typicode.com/posts/1/comments"
        val url ="http://apiedu.bentic.com/api/configuration/public"
        GET(url, object: Callback {
            //anonymous class
            override fun onResponse(call: Call?, response: Response) {
                if(response.code() != 200) {
                    return
                }
                val responseData = response.body()?.string()
                runOnUiThread{
                    try {
                        //var comments = JSONArray(responseData)
                        var json = JSONObject(responseData)
                        val code = json.getInt("code")
                        if(code == 0) {
                            val comments = json.getJSONArray("data")
                            for(i in 0..comments.length()) {
                                val comment = comments.get(i)
                                println("dd")
                            }
                            println("ddd")
                        }

                        println("Request Successful!!")
                        println(json)
//                        val responseObject = json.getJSONObject("response")
//                        val docs = json.getJSONArray("docs")
//                        this@MainActivity.fetchComplete()
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }
            }

            override fun onFailure(call: Call?, e: IOException?) {
                println("Request Failure.")
            }
        })
    }
}
