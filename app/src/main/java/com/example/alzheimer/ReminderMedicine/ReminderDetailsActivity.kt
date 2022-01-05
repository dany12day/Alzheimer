package com.example.alzheimer.ReminderMedicine

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.alzheimer.R

class ReminderDetailsActivity : AppCompatActivity() {

    private lateinit var myAdapter: RemindersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reminder_details)

        val reminderName = findViewById<TextView>(R.id.reminderName)
        val reminderMessage = findViewById<TextView>(R.id.reminderMessage)
        val reminderHours = findViewById<TextView>(R.id.reminderHours)
        val reminderDays = findViewById<TextView>(R.id.reminderDays)
        val reminderDelete = findViewById<Button>(R.id.reminderDelete)
        val reminderModify = findViewById<Button>(R.id.reminderModify)

        myAdapter = RemindersAdapter(
            context = this,
        )

        reminderName.text = myAdapter.getCurrentReminder().name.toString()
        reminderMessage.text = myAdapter.getCurrentReminder().message.toString()
        reminderHours.text = myAdapter.getCurrentReminder().timestamp?.hour.toString() + ":" +
                             myAdapter.getCurrentReminder().timestamp?.minute.toString() + ":" +
                             myAdapter.getCurrentReminder().timestamp?.second.toString()

        var days: String = ""

        val numbersIterator =  myAdapter.getCurrentReminder().timestamp?.dayOfTheWeek?.day?.iterator()
        while (numbersIterator?.hasNext() == true) {
            var number = numbersIterator.next()
            if (number == 1)
                days += "Monday "
            if (number == 2)
                days += "Tuesday "
            if (number == 3)
                days += "Wednesday "
            if (number == 4)
                days += "Thursday "
            if (number == 5)
                days += "Friday "
            if (number == 6)
                days += "Saturday "
            if (number == 7)
                days += "Sunday "
        }

        reminderDays.text = days

        reminderDelete.setOnClickListener {
            myAdapter.deleteReminder(myAdapter.getCurrentReminder())

            val intent = Intent(this@ReminderDetailsActivity, ReminderMedicineActivity::class.java)
            startActivity(intent)
        }

        reminderModify.setOnClickListener {
            val intent = Intent(this@ReminderDetailsActivity, UpdateReminderActivity::class.java)
            startActivity(intent)
        }
    }
}