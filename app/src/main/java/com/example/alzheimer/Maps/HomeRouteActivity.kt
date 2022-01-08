package com.example.alzheimer.Maps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.alzheimer.R
import com.example.alzheimer.ReminderMedicine.RemindersAdapter

class HomeRouteActivity : AppCompatActivity() {

    private lateinit var myAdapter: ImportantLocationsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_route)

//        myAdapter = ImportantLocationsAdapter(
//            context = this,
//        )
//
//        val spinner: Spinner = findViewById(R.id.spinner)
//        ArrayAdapter.createFromResource(
//            this,
//            myAdapter.getImportantLocationsList(),
//            android.R.layout.simple_spinner_item
//        ).also { adapter ->
//            // Specify the layout to use when the list of choices appears
//            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//            // Apply the adapter to the spinner
//            spinner.adapter = adapter
//        }

//        val intent = Intent(this@HomeRouteActivity, MapsActivity::class.java)
//        startActivity(intent)

    }
}