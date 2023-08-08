package com.example.introduce

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        val id_user = findViewById<EditText>(R.id.user_name)
        val password_user = findViewById<EditText>(R.id.user_password)

        val login_btn = findViewById<Button>(R.id.login_btn)

        login_btn.setOnClickListener {

            val id = id_user.text.toString()
            val password = password_user.text.toString()
            if(id.isNotEmpty() && password.isNotEmpty()) // id 와 password 가 채워져있을떄 동작
            {
                val intent_login = Intent(this, HomeActivity::class.java)
                intent.putExtra("id", id) // 아이디를 Extra 로 전달
                startActivity(intent_login)
                Toast.makeText(this, " 로그인 성공 ",Toast.LENGTH_LONG).show() // Toast 로 팝업 생성

            } else {
                Toast.makeText(this,"아이디 / 비밀번호를 확인해주세요.",Toast.LENGTH_LONG).show()
            }

        }

        val signup_btn = findViewById<Button>(R.id.signup_btn)
        signup_btn.setOnClickListener {
            val intent_signup = Intent(this, SignUpActivity::class.java)
            startActivity(intent_signup)
        }
    }
}