package com.example.alzheimer.Util

import com.example.alzheimer.Documents.DocumentModel
import com.example.alzheimer.Emergency.Contact
import com.example.alzheimer.Maps.ImportantLocation
import com.example.alzheimer.Maps.ImportantLocationsAdapter
import com.example.alzheimer.Notes.NoteModel
import com.example.alzheimer.ReminderMedicine.Reminder

data class UserData(
    var importantLocationsList: MutableList<ImportantLocation> = mutableListOf(),
    var remindersList: MutableList<Reminder> = mutableListOf(),
    var contactsList: MutableList<Contact> = mutableListOf(),
    var notesList: MutableList<NoteModel> = mutableListOf(),
    var documentsList: MutableList<DocumentModel> = mutableListOf()
)