package com.example.introduce

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Random

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val user_id = findViewById<TextView>(R.id.user_id_extra)
        val imageView = findViewById<ImageView>(R.id.image)
        val finish_btn = findViewById<Button>(R.id.button)

        val randomImageNames = arrayOf("one", "two", "three", "four", "five")
        val randomIndex = Random().nextInt(randomImageNames.size)
        val randomImageName = randomImageNames[randomIndex]
        val imageResourceId = resources.getIdentifier(randomImageName, "drawable", packageName)
        imageView.setImageResource(imageResourceId)

        val id = intent.getStringExtra("id")
        user_id.text = id

        finish_btn.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
            finish()
            Toast.makeText(this, id, Toast.LENGTH_LONG).show()
        }
    }
}
