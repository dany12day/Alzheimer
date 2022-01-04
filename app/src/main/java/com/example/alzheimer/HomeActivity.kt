package com.example.alzheimer

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val reminderMedicineButton = findViewById<Button>(R.id.reminderMedicineButton)
        reminderMedicineButton.setOnClickListener {

            val intent = Intent(this@HomeActivity, ReminderMedicineActivity::class.java)
            startActivity(intent)
        }

        val homeRouteButton = findViewById<Button>(R.id.homeRouteButton)
        homeRouteButton.setOnClickListener {

            val intent = Intent(this@HomeActivity, HomeRouteActivity::class.java)
            startActivity(intent)
        }

        val emergencyButton = findViewById<Button>(R.id.emergencyButton)
        emergencyButton.setOnClickListener {

            val intent = Intent(this@HomeActivity, EmergencyActivity::class.java)
            startActivity(intent)
        }
    }
}