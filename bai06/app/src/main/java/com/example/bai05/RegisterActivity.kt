package com.example.bai05

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bai05.models.User
import kotlinx.android.synthetic.main.register_activity.*

private lateinit var loginActivity: LoginActivity
class RegisterActivity : AppCompatActivity() {
    private lateinit var user:User
    companion object {
        //"static method / property",
        // xem lai "static property , static method" va instance method, instance property trong Java
        fun getParentActivity(_loginActivity: LoginActivity) {
            loginActivity = _loginActivity
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_activity)
//        val user = (intent.getStringExtra("user") as User).apply {
//            txtInfo.text = email
//        }
        user = intent.getSerializableExtra("user") as User
        println("haha = ${user.email}")
        println(loginActivity)
        btnDismiss.setOnClickListener {
            println("Presss dissmisssssss")
            loginActivity.reloadData()
            finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        println("dissstroooy man 2222")
    }
}
