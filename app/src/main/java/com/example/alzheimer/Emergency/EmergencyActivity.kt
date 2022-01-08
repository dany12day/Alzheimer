package com.example.alzheimer.Emergency

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import com.example.alzheimer.Maps.ImportantLocationsAdapter
import com.example.alzheimer.Maps.MapsActivity
import com.example.alzheimer.R

class EmergencyActivity : AppCompatActivity() {

    private lateinit var myAdapter: ContactsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emergency)

        myAdapter = ContactsAdapter(
            context = this,
        )

        val spinner: Spinner = findViewById(R.id.emergencySpinner)

        val adapter: ArrayAdapter<String> =
            ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, myAdapter.getContactsNameList())
        spinner.adapter = adapter

        var call = findViewById<Button>(R.id.call)
        call.setOnClickListener {

            var string: String = spinner.selectedItem.toString();

            val intent = Intent(this@EmergencyActivity, CallActivity::class.java)
            startActivity(intent)
        }
    }
}