package com.example.alzheimer.Maps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import com.example.alzheimer.R
import com.example.alzheimer.ReminderMedicine.RemindersAdapter

class HomeRouteActivity : AppCompatActivity() {

    private lateinit var myAdapter: ImportantLocationsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_route)

        myAdapter = ImportantLocationsAdapter(
            context = this,
        )

        val spinner: Spinner = findViewById(R.id.spinner)

        val adapter: ArrayAdapter<String> =
            ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, myAdapter.getImportantLocationsNameList())
        spinner.adapter = adapter

        var selectRoute = findViewById<Button>(R.id.selectRoute)
        selectRoute.setOnClickListener {

            var string: String = spinner.selectedItem.toString();

            val intent = Intent(this@HomeRouteActivity, MapsActivity::class.java)
            startActivity(intent)
        }

    }
}