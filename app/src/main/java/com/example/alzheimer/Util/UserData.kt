package com.example.alzheimer.Util

import com.example.alzheimer.Maps.ImportantLocation
import com.example.alzheimer.Maps.ImportantLocationsAdapter
import com.example.alzheimer.Notes.NoteModel
import com.example.alzheimer.ReminderMedicine.Reminder

data class UserData(
    var importantLocations: MutableList<ImportantLocation> = mutableListOf() ,
    var remindersList: MutableList<Reminder> = mutableListOf(),
    var notesList: MutableList<NoteModel> = mutableListOf()
)