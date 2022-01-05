package com.example.alzheimer.ReminderMedicine

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import com.example.alzheimer.R
import com.google.android.material.textfield.TextInputEditText

class UpdateReminderActivity : AppCompatActivity() {

    private lateinit var myAdapter: RemindersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_reminder)

        val updateReminderNameText = findViewById<TextView>(R.id.updateReminderNameText)
        val updateReminderMessageText = findViewById<TextView>(R.id.updateReminderMessageText)
        val updateReminderTimeText = findViewById<TextView>(R.id.updateReminderTimeText)
        val updateReminderName = findViewById<TextInputEditText>(R.id.updateReminderName)
        val updateReminderMessage = findViewById<TextInputEditText>(R.id.updateReminderMessage)
        val updateReminderTime = findViewById<TextInputEditText>(R.id.updateReminderTime)


        updateReminderNameText.text = "Name:"
        updateReminderMessageText.text = "Message:"
        updateReminderTimeText.text = "Time:"

        myAdapter = RemindersAdapter(
            context = this,
        )

        updateReminderName.setText(myAdapter.getCurrentReminder().name)
        updateReminderMessage.setText(myAdapter.getCurrentReminder().message)
        updateReminderTime.setText(myAdapter.getCurrentReminder().timestamp?.hour.toString() + ":" + myAdapter.getCurrentReminder().timestamp?.minute.toString() + ":" + myAdapter.getCurrentReminder().timestamp?.second.toString())

        val numbersIterator =  myAdapter.getCurrentReminder().timestamp?.dayOfTheWeek?.day?.iterator()
        while (numbersIterator?.hasNext() == true) {
            var number = numbersIterator.next()
            if (number == 1)
                findViewById<CheckBox>(R.id.checkboxMonday).isChecked = true
            if (number == 2)
                findViewById<CheckBox>(R.id.checkboxTuesday).isChecked = true
            if (number == 3)
                findViewById<CheckBox>(R.id.checkboxWednesday).isChecked = true
            if (number == 4)
                findViewById<CheckBox>(R.id.checkboxThursday).isChecked = true
            if (number == 5)
                findViewById<CheckBox>(R.id.checkboxFriday).isChecked = true
            if (number == 6)
                findViewById<CheckBox>(R.id.checkboxSaturday).isChecked = true
            if (number == 7)
                findViewById<CheckBox>(R.id.checkboxSunday).isChecked = true
        }

        val updateReminder = findViewById<Button>(R.id.updateReminder)
        updateReminder.setOnClickListener {

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

            val list = updateReminderTime.text.toString().split(":")

            val customDate : CustomDate = CustomDate(dayOfTheWeek, list.get(0).toInt(), list.get(1).toInt(), list.get(2).toInt())

            var reminder: Reminder = Reminder(updateReminderName.text.toString(), updateReminderMessage.text.toString(), customDate)

            myAdapter.updateReminder(reminder,myAdapter.getCurrentReminder())

            val intent = Intent(this@UpdateReminderActivity, ReminderMedicineActivity::class.java)
            startActivity(intent)
        }
    }
}