package com.example.alzheimer.HomeRegisterLogin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.alzheimer.ChatActivity.ChatActivity
import com.example.alzheimer.DataConfiguration.DataConfigurationActivity
import com.example.alzheimer.Notes.NotesActivity
import com.example.alzheimer.Emergency.EmergencyActivity
import com.example.alzheimer.Maps.HomeRouteActivity
import com.example.alzheimer.NearbyPharmaciesActivity
import com.example.alzheimer.PersonalInformation.Personallnformation
import com.example.alzheimer.R
import com.example.alzheimer.ReminderMedicine.ReminderMedicineActivity
import com.example.alzheimer.Util.CurrentUser

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

        val personalInfo = findViewById<Button>(R.id.personalInfoButton)
        personalInfo.setOnClickListener {
            val intent = Intent(this@HomeActivity, Personallnformation::class.java)
            startActivity(intent)
        }

        val patientConfiguration = findViewById<Button>(R.id.patientInfoConfigurationButton)
        patientConfiguration.setOnClickListener {
            val intent = Intent(this@HomeActivity, DataConfigurationActivity::class.java)
            startActivity(intent)
        }
        val chat = findViewById<Button>(R.id.ChatButton)
        chat.setOnClickListener {
            val intent = Intent(this@HomeActivity, ChatActivity::class.java)
            startActivity(intent)
        }

    }
}