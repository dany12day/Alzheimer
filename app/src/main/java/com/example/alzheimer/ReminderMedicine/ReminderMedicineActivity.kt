package com.example.alzheimer.ReminderMedicine

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ListView
import com.example.alzheimer.R


class ReminderMedicineActivity : AppCompatActivity() {

    private lateinit var myAdapter: RemindersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reminder_medicine)

        val listView = findViewById<ListView>(R.id.remindersList)

        val createReminderButton = findViewById<Button>(R.id.createReminderButton)

        myAdapter = RemindersAdapter(
            context = this,
        )
        listView.adapter = myAdapter

        listView.visibility = View.VISIBLE

        listView.setOnItemClickListener { parent, view, position, id ->
            myAdapter.setCurrentReminder(myAdapter.getItem(position) as Reminder)

            val intent = Intent(this, ReminderDetailsActivity::class.java)
            startActivity(intent)
        }

        createReminderButton.setOnClickListener {
            val intent = Intent(this@ReminderMedicineActivity, UpdateReminderActivity::class.java)
            startActivity(intent)
        }
    }

}