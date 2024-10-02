package com.example.empoweringthenation

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity



class First_Aid : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_aid)

        val backButton = findViewById<Button>(R.id.backButton)
        backButton.setOnClickListener {
            finish()
        }
    }
}