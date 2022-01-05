package com.example.alzheimer.ReminderMedicine

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import com.example.alzheimer.R
import com.google.android.material.textfield.TextInputEditText

class CreateReminderActivity : AppCompatActivity() {

    private lateinit var myAdapter: RemindersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_create_reminder)
        val createReminderNameText = findViewById<TextView>(R.id.createReminderNameText)
        val createReminderMessageText = findViewById<TextView>(R.id.createReminderMessageText)
        val createReminderTimeText = findViewById<TextView>(R.id.createReminderTimeText)
        val createReminderName = findViewById<TextInputEditText>(R.id.createReminderName)
        val createReminderMessage = findViewById<TextInputEditText>(R.id.createReminderMessage)
        val createReminderTime = findViewById<TextInputEditText>(R.id.createReminderTime)


        createReminderNameText.text = "Name:"
        createReminderMessageText.text = "Message:"
        createReminderTimeText.text = "Time:"


        val createReminder = findViewById<Button>(R.id.createReminder)
        createReminder.setOnClickListener {

            myAdapter = RemindersAdapter(
                context = this,
            )

            val dayOfTheWeek : DayOfTheWeek = DayOfTheWeek()

            if(findViewById<CheckBox>(R.id.checkboxMonday).isChecked){
                dayOfTheWeek.day.add(1)
            }
            if(findViewById<CheckBox>(R.id.checkboxTuesday).isChecked){
                dayOfTheWeek.day.add(2)
            }
            if(findViewById<CheckBox>(R.id.checkboxWednesday).isChecked){
                dayOfTheWeek.day.add(3)
            }
            if(findViewById<CheckBox>(R.id.checkboxThursday).isChecked){
                dayOfTheWeek.day.add(4)
            }
            if(findViewById<CheckBox>(R.id.checkboxFriday).isChecked){
                dayOfTheWeek.day.add(5)
            }
            if(findViewById<CheckBox>(R.id.checkboxSaturday).isChecked){
                dayOfTheWeek.day.add(6)
            }
            if(findViewById<CheckBox>(R.id.checkboxSunday).isChecked){
                dayOfTheWeek.day.add(7)
            }

            val list = createReminderTime.text.toString().split(":")

            val customDate : CustomDate = CustomDate(dayOfTheWeek, list.get(0).toInt(), list.get(1).toInt(), list.get(2).toInt())

            var reminder: Reminder = Reminder(createReminderName.text.toString(), createReminderMessage.text.toString(), customDate)

            myAdapter.addReminder(reminder)

            val intent = Intent(this@CreateReminderActivity, ReminderMedicineActivity::class.java)
            startActivity(intent)
        }



    }
}