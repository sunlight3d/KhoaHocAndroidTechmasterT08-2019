package com.example.myapp

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.google.gson.Gson
import org.json.JSONException
import org.json.JSONObject

class User(var name:String,
           var email: String,
           var address: String,
           var province : String,
           var token: String) {
    companion object {
        fun createUser(jsonObject: JSONObject): User? {
            try {
                val newUser = User(
                    jsonObject.getString("display_name"),
                    jsonObject.getString("email"),
                    "", "", ""
                )
                return newUser
            }catch (e: JSONException) {
                return null
                e.printStackTrace()
            }
        }
        fun getCurrentUser(context: Context?): User? {
            val sharedPreferences:SharedPreferences? = context?.
                            getSharedPreferences("user", MODE_PRIVATE)
            val gson = Gson()
            val strUser = sharedPreferences?.getString("user", "")
            val user:User = gson.fromJson(strUser,User::class.java) as User
            return user

        }
    }
    fun saveCurrentUser(context: Context?) {
        val sharedPreferences:SharedPreferences.Editor = context?.
                    getSharedPreferences("user", MODE_PRIVATE)!!.edit().apply {
            putString("user", Gson().toJson(this@User))
            commit()
        }


    }


}