package com.example.introduce

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class SignInActivity : AppCompatActivity() {

    private lateinit var sign_up: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        val id_user = findViewById<EditText>(R.id.user_name)
        val password_user = findViewById<EditText>(R.id.user_password)

        val signup_btn = findViewById<Button>(R.id.signup_btn)
        val login_btn = findViewById<Button>(R.id.login_btn)

        login_btn.setOnClickListener {

            val id = id_user.text.toString()
            val password = password_user.text.toString()
            if (id.isNotEmpty() && password.isNotEmpty()) {
                val intent_login = Intent(this, HomeActivity::class.java)
                intent_login.putExtra("id", id)
                startActivity(intent_login)
            } else {
                Toast.makeText(this, "아이디 / 비밀번호를 확인해주세요.", Toast.LENGTH_LONG).show()
            }
        }

        signup_btn.setOnClickListener {
            val intent_signup = Intent(this, SignUpActivity::class.java)
            sign_up.launch(intent_signup)
        }

        sign_up = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data = result.data
                val idData = data?.getStringExtra("signUpId") ?: ""
                id_user.setText(idData)
                val passwordData = data?.getStringExtra("signUpPassword") ?: ""
                password_user.setText(passwordData)
            }
        }
    }
}
