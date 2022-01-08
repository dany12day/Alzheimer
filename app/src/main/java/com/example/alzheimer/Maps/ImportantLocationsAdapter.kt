package com.example.alzheimer.Maps

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.alzheimer.ReminderMedicine.CustomDate
import com.example.alzheimer.ReminderMedicine.DayOfTheWeek
import com.example.alzheimer.ReminderMedicine.Reminder
import com.example.alzheimer.ReminderMedicine.RemindersAdapter
import com.example.alzheimer.Util.CurrentUser

class ImportantLocationsAdapter (
    private val context: Context,
) : BaseAdapter() {

    companion object {

        private var importantLocationsList: MutableList<ImportantLocation> = mutableListOf()

        private var currentImportantLocation: ImportantLocation = ImportantLocation("", "")
    }

    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int = importantLocationsList.size

    override fun getItem(p0: Int): Any = importantLocationsList[p0]

    override fun getItemId(p0: Int): Long = p0.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        TODO("Not yet implemented")
    }

    fun getImportantLocationsList(): MutableList<ImportantLocation> {
        return importantLocationsList
    }

    fun setList(importantLocationsListNew: MutableList<ImportantLocation>) {
        importantLocationsList = importantLocationsListNew
        notifyDataSetChanged()
    }
}