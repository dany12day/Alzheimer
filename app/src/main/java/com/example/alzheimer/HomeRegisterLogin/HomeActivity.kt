package com.example.alzheimer.HomeRegisterLogin

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.alzheimer.Documents.DocumentsActivity
import com.example.alzheimer.ChatActivity.ChatActivity
import com.example.alzheimer.DataConfiguration.DataConfigurationActivity
import com.example.alzheimer.Notes.NotesActivity
import com.example.alzheimer.Emergency.EmergencyActivity
import com.example.alzheimer.Maps.HomeRouteActivity
import com.example.alzheimer.Pharmacies.NearbyPharmaciesActivity
import com.example.alzheimer.PersonalInformation.Personallnformation
import com.example.alzheimer.R
import com.example.alzheimer.ReminderMedicine.ReminderMedicineActivity

class HomeActivity : AppCompatActivity(){

    var userIsOpen = false
    var medicationIsOpen = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val fabOpen = AnimationUtils.loadAnimation(this, R.anim.menu_open)
        val fabClose = AnimationUtils.loadAnimation(this, R.anim.menu_close)

        val userButton = findViewById<Button>(R.id.userButton)
        val reminderMedicineButton = findViewById<Button>(R.id.reminderMedicineButton)
        val homeRouteButton = findViewById<Button>(R.id.homeRouteButton)
        val emergencyButton = findViewById<AppCompatButton>(R.id.emergencyButton)
        val nearbyPharmacies = findViewById<Button>(R.id.nearbyPharmaciesButton)
        val notes = findViewById<Button>(R.id.notesButton)
        val documents = findViewById<Button>(R.id.documentsButton)
        val personalInfo = findViewById<Button>(R.id.personalInfoButton)
        val patientConfiguration = findViewById<Button>(R.id.patientInfoConfigurationButton)
        val chat = findViewById<Button>(R.id.messengerButton)
        val medicationButton = findViewById<Button>(R.id.medicineButton)

        reminderMedicineButton.setOnClickListener {

            val intent = Intent(this@HomeActivity, ReminderMedicineActivity::class.java)
            startActivity(intent)
        }

        homeRouteButton.setOnClickListener {

            val intent = Intent(this@HomeActivity, HomeRouteActivity::class.java)
            startActivity(intent)
        }

        emergencyButton.setOnClickListener {

            val intent = Intent(this@HomeActivity, EmergencyActivity::class.java)
            startActivity(intent)
        }

        nearbyPharmacies.setOnClickListener{
            val intent = Intent(this@HomeActivity, NearbyPharmaciesActivity::class.java)
            startActivity(intent)
        }

        notes.setOnClickListener {
            val intent = Intent(this@HomeActivity, NotesActivity::class.java)
            startActivity(intent)
        }

        documents.setOnClickListener {
            val intent = Intent(this@HomeActivity, DocumentsActivity::class.java)
            startActivity(intent)
        }

        personalInfo.setOnClickListener {
            val intent = Intent(this@HomeActivity, Personallnformation::class.java)
            startActivity(intent)
        }

        patientConfiguration.setOnClickListener {
            val intent = Intent(this@HomeActivity, DataConfigurationActivity::class.java)
            startActivity(intent)
        }

        chat.setOnClickListener {
            val intent = Intent(this@HomeActivity, ChatActivity::class.java)
            startActivity(intent)
        }

        userButton.setOnClickListener {
            if(userIsOpen){
                personalInfo.startAnimation(fabClose)
                patientConfiguration.startAnimation(fabClose)
                notes.startAnimation(fabClose)
                documents.startAnimation(fabClose)
                emergencyButton.startAnimation(fabOpen)
                homeRouteButton.startAnimation(fabOpen)
                medicationButton.startAnimation(fabOpen)
                chat.startAnimation(fabOpen)

                emergencyButton.isClickable
                homeRouteButton.isClickable
                medicationButton.isClickable
                chat.isClickable

                userIsOpen = false
            }
            else{
                personalInfo.startAnimation(fabOpen)
                patientConfiguration.startAnimation(fabOpen)
                notes.startAnimation(fabOpen)
                documents.startAnimation(fabOpen)
                emergencyButton.startAnimation(fabClose)
                homeRouteButton.startAnimation(fabClose)
                medicationButton.startAnimation(fabClose)
                chat.startAnimation(fabClose)

                personalInfo.isClickable
                patientConfiguration.isClickable
                notes.isClickable
                documents.isClickable

                userIsOpen = true
            }
        }

        medicationButton.setOnClickListener {
            if(medicationIsOpen){
                reminderMedicineButton.startAnimation(fabClose)
                nearbyPharmacies.startAnimation(fabClose)
                emergencyButton.startAnimation(fabOpen)
                homeRouteButton.startAnimation(fabOpen)
                userButton.startAnimation(fabOpen)
                chat.startAnimation(fabOpen)

                emergencyButton.isClickable
                homeRouteButton.isClickable
                userButton.isClickable
                chat.isClickable

                medicationIsOpen = false
            }
            else{
                emergencyButton.startAnimation(fabClose)
                homeRouteButton.startAnimation(fabClose)
                userButton.startAnimation(fabClose)
                chat.startAnimation(fabClose)
                reminderMedicineButton.startAnimation(fabOpen)
                nearbyPharmacies.startAnimation(fabOpen)

                reminderMedicineButton.isClickable
                nearbyPharmacies.isClickable

                medicationIsOpen = true
            }
        }

    }
}