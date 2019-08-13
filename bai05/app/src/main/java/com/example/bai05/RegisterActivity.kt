package com.example.bai05

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bai05.models.User
import kotlinx.android.synthetic.main.register_activity.*

class RegisterActivity : AppCompatActivity() {
    private lateinit var user:User
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_activity)
//        val user = (intent.getStringExtra("user") as User).apply {
//            txtInfo.text = email
//        }
        user = intent.getSerializableExtra("user") as User
        println("haha = ${user.email}")
        btnDismiss.setOnClickListener { finish() }
    }

    override fun onDestroy() {
        super.onDestroy()
        println("dissstroooy man 2222")
    }
}
