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
import java.util.*
import kotlin.collections.HashMap

class MainActivity : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        //val url = "https://jsonplaceholder.typicode.com/posts/1/comments"
        val user = User.getCurrentUser(this)
        testPost()

    }
    fun testPost(){
        val url = "https://api.gapo.vn/main/v1.0/auth/password-login"
        POST(url, hashMapOf("phone" to "0369136877", "password" to "12345678a"), object: Callback {
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
                        if(json.getString("name").equals("Success")) {
                            var jsonUser = json.getJSONObject("user")
                            var jsonUserInfo = jsonUser.getJSONObject("user_info")
                            val user: User? = User.createUser(jsonUser)
                            user?.token = json.getString("token")
                            user?.address = jsonUserInfo.getString("address")
                            user?.province = jsonUserInfo.getString("province")
                            user?.saveCurrentUser(this@MainActivity)
                            println("aa")
                        }
                        println("Request Successful!!")
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
    fun testGet() {
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

