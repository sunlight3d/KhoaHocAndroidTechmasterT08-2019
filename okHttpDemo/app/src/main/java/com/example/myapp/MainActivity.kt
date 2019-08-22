package com.example.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.main_activity.*
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
        //"phone" to "0369136877", "password" to "12345678a")
        txtPhone.setText("0369136877")
        txtPassword.setText("12345678a")
        //val url = "https://jsonplaceholder.typicode.com/posts/1/comments"

        //testPost()
        btnLogin.setOnClickListener {
            login(txtPhone.text.toString().trim(), txtPassword.text.toString())
        }
    }
    fun login(phone: String, password: String){
        val url = "https://api.gapo.vn/main/v1.0/auth/password-login"
        //POST(url, hashMapOf("phone" to "0369136877", "password" to "12345678a"), object: Callback {
        POST(url, hashMapOf("phone" to phone, "password" to password), object: Callback {
            //anonymous class
            override fun onResponse(call: Call?, response: Response) {
                if(response.code() != 200) {
                    runOnUiThread{
                        txtName.text = "Login failed.Code:${response.code()}"
                    }

                } else {
                    val responseData = response.body()?.string()
                    runOnUiThread{
                        try {
                            //var comments = JSONArray(responseData)
                            var json = JSONObject(responseData)
                            if(json.getString("name").equals("Success")) {
                                var jsonUser = json.getJSONObject("user")
                                var jsonUserInfo = jsonUser.getJSONObject("user_info")
                                var user: User? = User.createUser(jsonUser)
                                user?.token = json.getString("token")
                                user?.address = jsonUserInfo.getString("address")
                                user?.province = jsonUserInfo.getString("province")
                                user?.saveCurrentUser(this@MainActivity)
                                println("aa")
                                User.getCurrentUser(this@MainActivity).apply {
                                    txtName.text = "Login ok: ${this?.name}"
                                }

                            } else {
                                txtName.text = "Login failed"
                            }
                            println("Request Successful!!")
                        } catch (e: JSONException) {
                            txtName.text = "Login failed"
                            e.printStackTrace()
                        }
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

