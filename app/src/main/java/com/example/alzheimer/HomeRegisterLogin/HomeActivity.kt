package com.example.alzheimer.HomeRegisterLogin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.alzheimer.Notes.NotesActivity
import com.example.alzheimer.Emergency.EmergencyActivity
import com.example.alzheimer.Maps.HomeRouteActivity
import com.example.alzheimer.NearbyPharmaciesActivity
import com.example.alzheimer.R
import com.example.alzheimer.ReminderMedicine.ReminderMedicineActivity

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

        val nearbyPharmacies = findViewById<Button>(R.id.nearbyPharmaciesButton)
        nearbyPharmacies.setOnClickListener{
            val intent = Intent(this@HomeActivity, NearbyPharmaciesActivity::class.java)
            startActivity(intent)
        }

        val notes = findViewById<Button>(R.id.notesButton)
        notes.setOnClickListener {
            val intent = Intent(this@HomeActivity, NotesActivity::class.java)
            startActivity(intent)
        }
    }
}