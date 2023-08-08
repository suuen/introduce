package com.example.introduce

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val user_id = findViewById<TextView>(R.id.user_id_extra)
        val finish_btn = findViewById<Button>(R.id.button)

        val id = intent.getStringExtra("id")
        user_id.setText(id)

        finish_btn.setOnClickListener{
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
            finish()
            Toast.makeText(this, "${id}",Toast.LENGTH_LONG).show()
        }
    }
}