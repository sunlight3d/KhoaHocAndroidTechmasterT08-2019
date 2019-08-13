package com.example.bai05

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.bai05.models.User
import kotlinx.android.synthetic.main.login_activity.*

class LoginActivity : Activity(), IActivity {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)
        setupUI()
        setupActions()
        println("onCreate")
    }

    override fun setupUI() {

    }

    override fun setupActions() {
        btnLogin.setOnClickListener {

        }
        btnRegister.setOnClickListener {
            val email = txtEmail.text.toString()
            val password = txtPassword.text.toString()
            println("press REgisstttttttt")
            val intent = Intent(this, RegisterActivity::class.java).apply {
                val user = User("", email, password)
                putExtra("user", user)
            }

            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        println("onStart")
    }

    override fun onResume() {
        super.onResume()
        println("onResume")
    }

    override fun onPause() {
        super.onPause()
        println("onPause")
    }

    override fun onStop() {
        super.onStop()
        println("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("onDestroy")
    }
}
/*
first time:
onCreate -> onStart -> onResume
User press "home": onPause -> onStop

User choose "App":  onStart -> onResume

User exit app: onPause, onStop

User show second Activity: onPause -> onStop

* */
