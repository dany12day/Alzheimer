package com.example.alzheimer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val reminderMedicineButton = findViewById<Button>(R.id.registerUserButton)
        reminderMedicineButton.setOnClickListener {

            // sava user in database

            val intent = Intent(this@RegisterActivity, MainActivity::class.java)
            startActivity(intent)

        }
    }
}