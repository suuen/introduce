package com.example.introduce


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val id_user =findViewById<EditText>(R.id.user_id)
        val password_user = findViewById<EditText>(R.id.user_pwd)
        val name_user = findViewById<EditText>(R.id.user_name)

        val back_button = findViewById<Button>(R.id.signup_btn)

        back_button.setOnClickListener{

            val id = id_user.text.toString()
            val password = password_user.text.toString()
            val name = name_user.text.toString()

            if(id.isNotEmpty() && password.isNotEmpty() && name.isNotEmpty())
            {
                val intent = Intent(this,SignInActivity::class.java)
                finish()
                Toast.makeText(this,"회원가입 완료",Toast.LENGTH_LONG).show()
            }else {
                Toast.makeText(this,"입력되지않은 정보가 있습니다.",Toast.LENGTH_LONG).show()

            }
        }


    }
}