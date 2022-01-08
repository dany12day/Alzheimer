package com.example.alzheimer.ReminderMedicine

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.alzheimer.R
import com.example.alzheimer.Util.CurrentUser

class RemindersAdapter (
    private val context: Context,
) : BaseAdapter() {

    companion object {

        private var remindersList: MutableList<Reminder> = mutableListOf()

        private var currentReminder: Reminder = Reminder("", "", CustomDate(DayOfTheWeek(mutableListOf()), 0, 0, 0))
    }

    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int = remindersList.size

    override fun getItem(p0: Int): Any = remindersList[p0]

    override fun getItemId(p0: Int): Long = p0.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = inflater.inflate(R.layout.item_reminder, parent, false)
        val titleView = rowView.findViewById<TextView>(R.id.medicineName)

        val joke = getItem(position) as Reminder

        titleView.text = "${joke.name}"

        return rowView
    }

    fun setCurrentReminder(joke: Reminder){
        currentReminder = joke
    }

    fun getCurrentReminder(): Reminder{
        return currentReminder
    }

    fun deleteReminder(reminder: Reminder){
        remindersList.remove(reminder)
        notifyDataSetChanged()
    }

    fun addReminder(reminder: Reminder) {
        remindersList.add(reminder)
        notifyDataSetChanged()
    }

    fun updateReminder(reminder: Reminder, currentReminder: Reminder) {
        remindersList.remove(currentReminder)
        remindersList.add(reminder)
        notifyDataSetChanged()
    }

    fun setList(remindersListNew: MutableList<Reminder>) {
        remindersList = remindersListNew
        notifyDataSetChanged()
    }

}