package com.example.empoweringthenation

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide

class Landscaping : AppCompatActivity() {

    private lateinit var landscapingImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_landscaping)

        landscapingImage = findViewById(R.id.imageView8)

        val backButton = findViewById<Button>(R.id.backButton)
        backButton.setOnClickListener {
            finish()
        }

        val feesButton = findViewById<Button>(R.id.feesButton)
        feesButton.setOnClickListener {
            val intent = Intent(this, Fees::class.java)
            startActivity(intent)
        }

        Glide.with(this)
            .load(R.drawable.landscaping)
            .into(landscapingImage)
    }
}

